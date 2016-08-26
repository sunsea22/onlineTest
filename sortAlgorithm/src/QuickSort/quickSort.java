package QuickSort;

import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/26.
 * 快速排序
 * 基本思想：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,一部分比基准元素小,
 * 一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
 */
public class quickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = scanner.nextInt();
            }
            quick(arr);
            for (int i = 0; i < num; i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
        }
        scanner.close();
    }

    private static int getMiddle(int[] list, int low, int high) {
        int tmp = list[low];

        while (low < high) {
            while (low < high && list[high] >= tmp) {
                high--;
            }
            list[low] = list[high];

            while (low < high && list[low] <= tmp) {
                low++;
            }
            list[high] = list[low];
        }
        list[low] = tmp;
        return low; //返回中轴的位置
    }

    private static void quick_sort(int[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high);
            quick_sort(list, low, middle - 1);
            quick_sort(list, middle + 1, high);
        }
    }

    private static void quick(int[] arr) {
        if (arr.length > 0) {
            quick_sort(arr, 0, arr.length -1);
        }
    }
}
