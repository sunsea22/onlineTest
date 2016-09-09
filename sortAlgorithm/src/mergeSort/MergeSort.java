package mergeSort;

import java.util.Arrays;

/**
 * Created by Sunsea on 16/9/9.
 * 基本排序：归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，
 * 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
 * 稳定
 * 时间复杂度O(nlogn)
 */
public class MergeSort {
    public void mergingSort(int[] a) {
        sort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }

    public void sort(int[] data, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            sort(data, left, center);
            sort(data, center+1, right);
            merge(data, left, center, right);
        }
    }

    public void merge(int[] data, int left, int center, int right) {
        int[] tmpArr = new int[data.length];
        int mid = center + 1;

        int third = left;
        int tmp = left;

        while (left <= center && mid <= right) {
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            }
            else {
                tmpArr[third++] = data[mid++];
            }
        }

        //剩余部分一次放入中间数组
        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }

        while (left <= center) {
            tmpArr[third++] = data[left++];
        }

        //将中间数组中的内容复制回原数组
        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }

        System.out.println("-----归并排序-----");

        System.out.println(Arrays.toString(data));
    }
}
