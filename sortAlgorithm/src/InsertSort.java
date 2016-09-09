/**
 * Created by Sunsea on 16/9/9.
 * 基本思想：在要排序的一组数中，假设前面(n-1) [n>=2] 个数已经是排
 好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数
 也是排好顺序的。如此反复循环，直到全部排好顺序。
 * 时间复杂度O(n的平方)
 * 稳定
 */
public class InsertSort {
    public void insertSort(int[] a) {
        int tmp = 0;
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            tmp = a[i];

            for (; j >= 0 && tmp < a[j]; j--) {
                a[j+1] = a[j];
            }
            a[j+1] = tmp;
        }
        System.out.println("-----直接插入排序------");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
