import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/24.
 * 求两个字符串的最长公共子序列
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            int[][] flag = LCSLength(a, b);
            PrintLCS(flag, a, a.length(), b.length());
            System.out.println("");
            //System.out.println("\n");
        }
        scanner.close();
    }

    private static int[][] LCSLength(String a, String b) {
        int aLen = a.length() + 1;
        int bLen = b.length() + 1;
        int[][] c = new int[aLen][bLen];
        int[][] flag = new int[aLen][bLen];

        for (int i = 0; i < aLen; i++) {
            c[i][0] = 0;
        }

        for (int i = 0; i < bLen; i++) {
            c[0][i] = 0;
        }

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    c[i][j] = c[i-1][j-1] + 1;
                    flag[i][j] = 0;
                }
                else if (c[i-1][j] >= c[i][j-1]) {
                    c[i][j] = c[i-1][j];
                    flag[i][j] = 1;
                }
                else {
                    c[i][j] = c[i][j-1];
                    flag[i][j] = -1;
                }
            }
        }
        return flag;
    }

    private static void PrintLCS(int[][] flag, String a, int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }
        if (flag[i][j] == 0) {
            PrintLCS(flag,a,i-1,j-1);
            System.out.print(a.charAt(i - 1));
        }
        else if (flag[i][j] == 1) {
            PrintLCS(flag, a, i-1, j);
        }
        else {
            PrintLCS(flag, a, i, j-1);
        }
    }
}
