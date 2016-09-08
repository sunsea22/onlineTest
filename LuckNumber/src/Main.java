import java.util.Scanner;

/**
 * Created by Sunsea on 16/9/5.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = scanner.nextInt();
            }
            int[] res = countNum(arr, num);
            for (int i = 0; i < num; i++) {
                System.out.println(res[i]);
            }
        }
        scanner.close();
    }

    private static int[] countNum(int[] arr, int num) {
        int[] res = new int[num];
        for (int i = 0; i < num; i++) {
            int count = 0;
            for (int j = 1; j <= arr[i]; j++) {
                if (f(j) == g(j)) count++;
            }
            res[i] = count;
        }
        return res;
    }

    private static int f(int n) {
        String str = String.valueOf(n);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count += str.charAt(i) - '0';
        }
        return count;
    }

    private static int g(int n) {
        int count = 0;
        while (n != 0) {
            int tmp = n & 1;
            n >>>= 1;
            if (tmp == 1) count++;
        }
        return count;
    }
}
