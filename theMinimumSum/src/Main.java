import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/28.
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
            System.out.println(minSum(arr));
        }
        scanner.close();
    }

    private static int[] popSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }

    //组成和看成背包容量，元素看成重量和价值相等的物品
    private static int minSum(int[] arr) {
        int[] sortArr = popSort(arr);

        int max = 0;
        int ret = 0;

        for (int i = 0; i < sortArr.length; i++) {
            max += sortArr[i];
        }

        int[][] m = new int[max+1][sortArr.length];
        int[][] tag = new int[max+1][sortArr.length];

        for (int i = 0; i < sortArr[0]; i++) {
            for (int j = 0; j < sortArr.length; j++) {
                m[i][j] = 0;
                tag[i][j] = 0;
            }
        }

        for (int i = sortArr[0]; i <= max; i++) {
            m[i][0] = sortArr[0];
            tag[i][0] = 1;
        }

        for (int j = 0; j < sortArr.length; j++) {
            m[sortArr[0]][j] = sortArr[0];
        }

        int i = 0;

        for (i = sortArr[0] + 1; i <= max; i++) {
            for (int j = 1; j < sortArr.length; j++) {
                m[i][j] = m[i][j-1];
                //背包j不大于总重量
                if (sortArr[j] <= i) {
                    //分为放与不放，前一种放入背包j，所以总重量要减去j的重量
                    if (m[i - sortArr[j]][j] + sortArr[j] > m[i][j-1]) {
                        if (tag[i-sortArr[j]][j] == 0) {
                            m[i][j] = m[i - sortArr[j]][j] + sortArr[j];
                            tag[i][j] = 1;
                        }
                        else {
                            m[i][j] = m[i][j-1];
                        }
                    }
                }
            }
            if (m[i][sortArr.length - 1] != i) {
                ret = i;
                break;
            }
        }
        if (i == max + 1) {
            ret = max + 1;
        }
        return ret;
    }
}
