import java.util.Scanner;

/**
 * Created by Sunsea on 16/9/3.
 * 依次删除字符串首位，判断删除后的字符串自否为回文数
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.next();
            System.out.println(addStrNum(input));
        }
        scanner.close();
    }

    private static String addStrNum(String input) {
        if (isPalindrom(input)) return null;
        String res = "";
        int len = 1;
        while (!input.isEmpty()) {
            res = input.charAt(0) + res;
            input = input.substring(len);
            if (isPalindrom(input))
                break;
        }
        return res;
    }

    private static boolean isPalindrom(String s) {
        String s1 = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            s1 += s.charAt(i);
        }
        if (s1.equals(s)) {
            return true;
        }
        else {
            return false;
        }
    }
}
