import java.util.Scanner;

/**
 * Created by Sunsea on 16/9/12.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            System.out.println(oddSum(num));
        }
        scanner.close();
    }

    private static int oddSum(int num) {
        int[] index = new int[num+1];
        for (int i = 1; i <= num; i++) {
            if (i%2 != 0) index[i] = i;
            else index[i] = index[i/2];
        }
        int sum = 0;
        for (int i = 1; i <= num; i++) sum += index[i];
        return sum;
    }
}
