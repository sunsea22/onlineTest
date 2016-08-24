import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/25.
 */
public class Main3 {
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            Print_LCS(a, b);
        }
    }

    private static void Print_LCS(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int[][] flag = new int[aLen+1][bLen+1];

        int max_lcs_length = lcs_length(a, b, flag, aLen, bLen);

        char[] result = new char[max_lcs_length];
        String[] change = new String[aLen+bLen];
        for (int i = 0; i < change.length; i++) {
            change[i] = "";
        }
        Display_lcs(a, aLen, bLen, flag, result, max_lcs_length, max_lcs_length, change);
        System.out.println(count);
        count = 0;
    }

    private static int lcs_length(String a, String b, int[][] flag, int aLen, int bLen) {
        int[][] c = new int[aLen+1][bLen+1];

        for (int i = 0; i <= aLen; i++) {
            c[i][0] = 0;
        }

        for (int i = 0; i <= bLen; i++) {
            c[0][i] = 0;
        }

        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    c[i][j] = c[i-1][j-1] + 1;
                    flag[i][j] = 1;
                }
                else if (c[i-1][j] > c[i][j-1]) {
                    c[i][j] = c[i-1][j];
                    flag[i][j] = 2;
                }
                else if (c[i-1][j] < c[i][j-1]) {
                    c[i][j] = c[i][j-1];
                    flag[i][j] = 3;
                }
                else {
                    c[i][j] = c[i-1][j];
                    flag[i][j] = 4;
                }
            }
        }
        return c[aLen][bLen];
    }

    private static void Display_lcs(String a, int i, int j, int[][] flag, char[] result, int current_len, int max_lcs_len, String[] change) {
        if (i == 0 || j == 0) {
            String tmp = "";
            for (int s = 0; s < max_lcs_len; s++) {
                tmp += result[s];
            }
            int k = 0;
            for (int m = 0; m < change.length; m++) {
                if (change[m].equals(tmp)) k++;
            }
            if (k == 0) {
                for (int v = 0; v < max_lcs_len; v++) {
                    System.out.print(result[v]);
                }
                System.out.println();
                change[count] = tmp;
                count++;
            }
            return;
        }
        if (flag[i][j] == 1) {
            current_len--;
            result[current_len] = a.charAt(i-1);
            Display_lcs(a, i-1, j-1, flag, result, current_len, max_lcs_len, change);
        }
        else {
            if (flag[i][j] == 2) {
                Display_lcs(a, i-1, j, flag, result, current_len, max_lcs_len, change);
            }
            else {
                if (flag[i][j] == 3) {
                    Display_lcs(a, i, j-1, flag, result, current_len, max_lcs_len, change);
                }
                else {
                    Display_lcs(a, i-1, j, flag, result, current_len, max_lcs_len, change);
                    Display_lcs(a, i, j-1, flag, result, current_len, max_lcs_len, change);
                }
            }
        }
    }
}
