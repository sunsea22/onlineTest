import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/24.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int[] a = new int[num];

            for (int i = 0; i < num; i++) {
                a[i] = scanner.nextInt();
            }

            System.out.println(getNum(a));
        }
        scanner.close();
    }

    private static int getNum(int[] a) {
        int[] ltr = getLeftToRight(a);
        int[] rtl = getRightToLeft(a);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (max < ltr[i] + rtl[i]) {
                max = ltr[i] + rtl[i] - 1; //两个最长上升子序列有一个公共元素，所以要减1
            }
        }
        return a.length - max;
    }

    private static int[] getLeftToRight(int[] a) {
        int[] ltr = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            ltr[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && ltr[i] <= ltr[j]) {
                    ltr[i] = ltr[j] + 1;
                }
            }
        }
        return ltr;
    }

    private static int[] getRightToLeft(int[] a) {
        int[] rtl = new int[a.length];

        for (int i = a.length - 1; i >= 0; i--) {
            rtl[i] = 1;
            for (int j = a.length - 1; j > i; j--) {
                if (a[i] > a[j] && rtl[i] <= rtl[j]) {
                    rtl[i] = rtl[j] + 1;
                }
            }
        }
        return rtl;
    }
}
