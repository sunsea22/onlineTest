import java.util.Scanner;

/**
 * Created by Sunsea on 16/9/5.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int target = scanner.nextInt();
            System.out.println(getPos(arr, n, target));
        }
        scanner.close();
    }

    private static int getPos(int[] A, int n, int  val) {
        int left = 0;
        int right = n - 1;
        int mid = 0;

        while (left < right) {
            mid = (right + left) / 2;
            if (A[mid] < val) left = mid + 1;
            else if (A[mid] > val) right = mid - 1;
            else right = mid;
        }
        if (A[left] == val) return left;
        return -1;
    }
}
