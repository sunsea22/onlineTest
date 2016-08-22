import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/22.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int[] matrix = new int[num*2];
            for (int i = 0; i < num*2; i++) {
                matrix[i] = scanner.nextInt();
            }
            String rule = scanner.next();
            System.out.println(countNum(matrix, rule));
        }
        scanner.close();
    }

    private static int countNum(int[] matrix, String rule) {
        //双向队列
        Deque<Integer> stack = new LinkedList<>();

        int idArr = 0;
        int idx = 0;
        int result = 0;

        while (idx < rule.length()) {
            char c = rule.charAt(idx);

            if (c != '(' && c != ')') {
                if (idx == 0) {
                    stack.addLast(matrix[idArr]);
                    stack.addLast(matrix[idArr+1]);
                }
                else {
                    char prev = rule.charAt(idx - 1);
                    if (prev != '(' && prev != ')') {
                        int col = stack.removeLast();
                        int row = stack.removeLast();
                        int col2 = matrix[idArr + 1];
                        result += row*col*col2;

                        stack.add(row);
                        stack.add(col2);
                    }
                    else {
                        stack.addLast(matrix[idArr]);
                        stack.addLast(matrix[idArr + 1]);
                    }

                    idArr += 2;
                }
            }
            idx++;
        }

        while (stack.size() > 2) {
            int col2 = stack.removeLast();
            int row2 = stack.removeLast();
            int col1 = stack.removeLast();
            int row1 = stack.removeLast();

            stack.addLast(row1);
            stack.addLast(col2);

            result += row1 * col1 * col2;
        }
        return result;
    }
}
