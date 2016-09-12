import java.util.Scanner;

/**
 * Created by Sunsea on 16/9/12.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int radius = scanner.nextInt();
            System.out.println(pointNum(radius));
        }
        scanner.close();
    }

    private static int pointNum(int r) {
        if (r <= 0) return 0;
        int flag = 0;
        for (int i = 1; i <= r; i++) {
            if (i*i == r) flag = 1;
        }
        if (flag == 0) return 0;
        int r1 = (int)Math.sqrt(r);
        int count = 0;
        for (int i = 0; i <= r1; i++) {
            for (int j = 0; j <= r1; j++) {
                if (i*i + j*j == r) count++;
            }
        }
        return count*4 - 4;
    }
}
