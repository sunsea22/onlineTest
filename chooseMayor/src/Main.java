import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Sunsea on 16/9/8.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        while ((num--) > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            if (n == 1) {
                System.out.print(1+"\n"+1);
                continue;
            }
            if (m < n-1) {
                System.out.print("0\n\n");
                continue;
            }

            int[] A = new int[n+1];

            for (int k = 0; k < m; k++) {
                int m1 = scanner.nextInt();
                int m2 = scanner.nextInt();

                if (m1 != m2) {
                    A[m1]--;
                    A[m2]++;
                }
            }

            String res = "";
            int count = 0;

            for (int j = 1; j <=n; j++) {
                if (A[j] == n -1) {
                    res += j + " ";
                    count++;
                }
            }
            if (count == 0) {
                System.out.print("0\n\n");
            }
            else {
                System.out.print(count+"\n"+res.trim()+"\n");
            }
        }
    }
}
