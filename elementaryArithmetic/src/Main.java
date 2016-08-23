import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/23.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.next();
            input = format(input);
            System.out.println(calculate(input));
        }

        scanner.close();
    }

    private static int calculate(String s) {
        //操作符栈
        Deque<Character> opts = new LinkedList<>();
        //操作数栈
        Deque<Integer> opds = new LinkedList<>();

        int idx = 0;
        while (idx < s.length()) {
            char c = s.charAt(idx);

            //如果是数字
            if (c >= '0' && c <= '9') {
                //计算数字的值
                int opd = 0;
                while (idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
                    opd = opd * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                opds.addLast(opd);
            }
            //如果是操作符
            else {
                //如果是左括号
                if (c == '(' || c == '[' || c == '{') {
                    opts.addLast(c);
                }
                //如果是右括号
                else if (c == ')' || c == ']' || c == '}') {
                    while (!opts.isEmpty() && opts.getLast() != '(' && opts.getLast() != '[' && opts.getLast() != '{') {
                        calculate(opts, opds);
                    }
                    opts.removeLast();
                }
                //如果是乘或者除
                else if (c == '*' || c == '/') {
                    while (!opts.isEmpty() && (opts.getLast() == '*' || opts.getLast() == '/')) {
                        calculate(opts, opds);
                    }
                    //操作符入栈
                    opts.addLast(c);
                }
                else if (c == '+' || c == '-') {
                    while (!opts.isEmpty() && (opts.getLast() == '*' || opts.getLast() == '/' || opts.getLast() == '+' || opts.getLast() == '-')) {
                        calculate(opts, opds);
                    }
                    //操作符入栈
                    opts.addLast(c);
                }
                //处理下一个字符
                idx++;
            }
        }
        while (!opts.isEmpty()) {
            calculate(opts, opds);
        }
        return opds.removeLast();
    }

    /**
     * 求值操作，取opt的最后一个操作符，opds中的最后两个操作数
     * @param opts 操作符栈
     * @param opds 操作数栈
     */
    private static void calculate(Deque<Character> opts, Deque<Integer> opds) {
        char opt = opts.removeLast();

        int v2 = opds.removeLast();
        int v1 = opds.removeLast();

        int v = calculate(v1, v2, opt);
        opds.addLast(v);
    }

    private static int calculate(int v1, int v2, char operator) {
        switch (operator) {
            case '+':
                return v1 + v2;
            case '-':
                return v1 - v2;
            case '*':
                return v1 * v2;
            case '/':
                return v1 / v2;
            default:
        }
        return 0;
    }

    /**
     * 将算术表达式归整，-5*3整理成0-5*3
     * @param s 算术表达式
     * @return 归整后的表达式
     */
    private static String format(String s) {
        String t = s.replaceAll(" ","");

        int idx = 0;

        while ((idx = t.indexOf('-',idx)) >= 0) {
            if (idx == 0) {
                t = '0' + t;
            }
            else {
                char c = t.charAt(idx - 1);

                if (c == '(' || c == '[' || c == '{') {
                    t = t.substring(0,idx) + '0' + t.substring(idx);
                }
            }
            idx++;
        }
        return t;
    }
}
