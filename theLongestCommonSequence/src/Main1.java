import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/25.
 */
public class Main1 {
    static int count = 0;
    static char[] result = new char[100];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            int aLen = a.length();
            int bLen = b.length();
            int[][] flag = new int[aLen+1][bLen+1];

            int max = Math.max(aLen,bLen);
            String[] change = new String[max+1];
            for (int i = 0; i < change.length; i++) {
                change[i] = "";
            }

            int lcs_max_len = Lcs_Length(a, b, flag, aLen, bLen);
            Display_Lcs(aLen, bLen, a, flag, lcs_max_len, lcs_max_len, change);
            System.out.println(count);
            count = 0;
        }
    }

    private static int Lcs_Length(String a, String b, int[][] flag, int aLen, int bLen) {
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
                    c[i][j] = c[i][j-1];
                    flag[i][j] = 4;
                }
            }
        }
        return c[aLen][bLen];
    }

    private static void Display_Lcs(int i, int j, String a, int[][] flag, int current_len, int lcs_max_len, String[] change) {
        if (i == 0 || j == 0) {
            String tmp = "";
            for (int s = 0; s < lcs_max_len; s++) {
                tmp += result[s];
            }
            int k = 0;
            for (int m = 0; m < change.length; m++) {
                if (change[m].equals(tmp)) k++;
            }
            if (k == 0) {
                for (int s = 0; s < lcs_max_len; s++) {
                    System.out.print(result[s]);
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
            Display_Lcs(i-1, j-1, a, flag, current_len, lcs_max_len, change);
        }
        else {
            if (flag[i][j] == 2) {
                Display_Lcs(i-1, j, a, flag, current_len, lcs_max_len, change);
            }
            else {
                if (flag[i][j] == 3) {
                    Display_Lcs(i, j-1, a, flag, current_len, lcs_max_len, change);
                }
                else {
                    Display_Lcs(i, j-1, a, flag, current_len,lcs_max_len, change);
                    Display_Lcs(i-1, j, a, flag, current_len,lcs_max_len, change);
                }
            }
        }
    }
}
