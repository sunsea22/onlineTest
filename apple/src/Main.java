import java.util.Scanner;

/**
 * Created by Sunsea on 16/9/12.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            System.out.println(bagNum(num));
        }
        scanner.close();
    }

    private static int bagNum(int num) {
        if (num == 6) return 1;
        if (num == 8) return 1;
        int min = num;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (6*i + 8 * j == num) {
                    if (min > i+j)
                        min = i+j;
                }
            }
        }
        if (min == num) return -1;
        else return min;
    }
}
