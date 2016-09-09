package radixSort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sunsea on 16/9/9.
 * 基本思想：将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。
 * 然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后,数列就变成一个有序序列。
 * 稳定
 */
public class RadixSort {
    public void radixSort(int[] a) {
        sort(a);
        System.out.println("-----计数排序-----");
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }

    public void sort(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        int time = 0;
        while (max > 0) {
            max /= 10;
            time++;
        }

        //建立10个队列
        List<ArrayList> queue = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> queue1 = new ArrayList<>();
            queue.add(queue1);
        }

        for (int i = 0; i < time; i++) {
            for (int j = 0; j < array.length; j++) {
                int x = array[i]%(int)Math.pow(10, i+1) / (int)Math.pow(10,i);
                ArrayList<Integer> queue2 = queue.get(x);
                queue2.add(array[i]);
                queue.set(x, queue2);
            }

            int count = 0;

            for (int k = 0; k < 10; k++) {
                while (queue.get(k).size() > 0) {
                    ArrayList<Integer> queue3 = queue.get(k);
                    array[count] = queue3.get(0);
                    queue3.remove(0);
                    count++;
                }
            }
        }
    }
}
