package BucketSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by Sunsea on 16/8/31.
 * 桶排序
 * 1,桶排序是稳定的
 * 2,桶排序是常见排序里最快的一种,比快排还要快…大多数情况下
 * 3,桶排序非常快,但是同时也非常耗空间,基本上是最耗空间的一种排序算法
 *
 * 有时候一个桶会有多个数
 */
public class BucketSort {
    public static void main(String[] args) {
        double array[] = { 0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.21, 0.12, 0.23, 0.68 };
        bucketSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            System.out.println();
        }

    }

    public static void bucketSort(double[] array) {
        int length = array.length;
        ArrayList arrList[] = new ArrayList[length];

        for (int i = 0; i < length; i++) {
            //0.7到0.79放在第8个桶里,编号7；第一个桶放0到0.09
            //Math.floor()此方法返回最大的（最接近正无穷大）浮点值小于或等于参数，并等于某个整数
            int temp = (int) Math.floor(10*array[i]);
            if (null == arrList[temp])
                arrList[temp] = new ArrayList();
            arrList[temp].add(array[i]);
        }

        //对每个桶中的数进行插入排序
        for (int i = 0; i < length; i++) {
            if (arrList[i] != null) {
                Collections.sort(arrList[i]);
            }
        }

        int count = 0;
        for (int i = 0; i < length; i++) {
            if (arrList[i] != null) {
                Iterator iter = arrList[i].iterator();
                while (iter.hasNext()) {
                    Double d = (Double) iter.next();
                    array[count] = d;
                    count++;
                }
            }
        }
    }
}
