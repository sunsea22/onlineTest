import java.util.Scanner;

/**
 * Created by Sunsea on 16/9/18.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(zeroNum(n));
        }
        scanner.close();
    }

    private static int zeroNum(int n) {
        int countFive = 0;
        for (int i = 5; i <= n; i++) {
            int tmp = i;
            while (tmp % 5 == 0) {
                tmp = tmp / 5;
                countFive++;
            }
        }
        return countFive;
    }
}
