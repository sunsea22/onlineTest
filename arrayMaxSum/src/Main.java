import java.util.Scanner;

/**
 * Created by Sunsea on 16/9/13.
 * 数组中取出下标不连续的任意个数，求取出的数的和的最大值
 *
 * 我们假设原数组为arr，辅助数组为data，首先设置辅助数组中data[0] = arr[0],data[1] = arr[1],
 * 假设我们当前要求的是data[i]，我们已经求得i-1之前不连续任意个数的和的最大值了，
 * 我们用arr[i]和data数组中前i-2个数依次相加，如果大于当前最大值，则更新当前最大值，如果小于则继续遍历。
 * 直到遍历到第i-2个位置为止
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
            System.out.println(maxSum(arr));
        }
        scanner.close();
    }

    private static int maxSum(int[] arr) {
        if (arr.length == 1) return arr[0];
        int[] tmp = new int[arr.length];
        tmp[0] = arr[0];
        tmp[1] = arr[1];
        int curMaxVal = tmp[0];

        if (tmp[1] > tmp[0])
            curMaxVal = tmp[1];
        for (int i = 2; i < arr.length; i++) {
            int val = arr[i];
            for (int j = 0; j < i - 1; ++j) {
                if (val + tmp[j] > curMaxVal) {
                    curMaxVal = val + tmp[j];
                }
            }
            tmp[i] = curMaxVal;
        }
        return curMaxVal;
    }
}
