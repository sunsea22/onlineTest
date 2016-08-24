import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/24.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            System.out.println(commonStr(a,b));
        }
        scanner.close();
    }

    private static String commonStr(String a, String b) {
        if (a.length() > b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }

        int aLen = a.length() + 1;
        int bLen = b.length() + 1;
        int max = 0;
        int x = 0;

        int[][] c = new int[aLen][bLen];

        for (int i = 0; i < aLen; i++) {
            c[i][0] = 0;
        }

        for (int i = 0; i < bLen; i++) {
            c[0][i] = 0;
        }

        for (int i = 1; i < aLen; i++) {
            for (int j = 1; j < bLen; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    c[i][j] = c[i-1][j-1] + 1;
                }
                else {
                    c[i][j] = 0;
                }
                if (max < c[i][j]) {
                    max = c[i][j];
                    x = i;
                }
            }
        }
        return a.substring(x - max, x);
    }
}
