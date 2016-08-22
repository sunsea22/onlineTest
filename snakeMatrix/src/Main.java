import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/22.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            System.out.println(snake(input));
        }

        scanner.close();
    }

    private static String snake(int input) {
        StringBuilder res = new StringBuilder();
        int[][] a = new int[input][input];

        for (int i = 0; i < input; i++) {
            //第一行
            if (i == 0) {
                for (int j = 0; j < input; j++) {
                    a[0][j] = (j+1)*(j+2) / 2;
                    if (j == 0) {
                        res.append(a[0][0]);
                    }
                    else {
                        res.append(" " + a[0][j]);
                    }
                }
            }
            else {
                //下面行的元素要比上面一行少一个，所以j取到input - i
                for (int j = 0; j < input - i; j++) {
                    a[i][j] = a[i-1][j+1] - 1;
                    if (j == 0) {
                        res.append(a[i][j]);
                    }
                    else {
                        res.append(" " + a[i][j]);
                    }
                }
            }
            if (i < input - 1) {
                res.append("\n");
            }
        }
        return res.toString();
    }
}
