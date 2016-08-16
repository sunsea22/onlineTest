import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] input = new int[3][3];
        while (scanner.hasNext()) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    input[i][j] = scanner.nextInt();
                }
            }
            System.out.println(SetArrayTopRightCornerTobeZero(input));
        }
        scanner.close();
    }

    public static String SetArrayTopRightCornerTobeZero(int a[][]) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            a[0][i] = 0;
        }
        for (int i = 1; i <= 2; i++) {
            a[1][i] = 0;
        }
        a[2][2] = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                res.append(a[i][j]);
            }
        }
        return res.toString();
    }
}
