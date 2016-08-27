package SelectSort;


import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/26.
 * 简单选择排序
 * 基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
 */
public class selectSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = scanner.nextInt();
            }
            int[] input = sort(arr);

            for (int i = 0; i < input.length; i++) {
                System.out.print(input[i]);
            }
            System.out.println();
        }
        scanner.close();
    }

    private static int[] sort(int[] arr) {
        int position = 0;
        for (int i = 0; i < arr.length; i++) {
            int j = i+1;
            position = i;
            int temp = arr[i];

            for (;j < arr.length; j++) {
                if (arr[j] < temp) {
                    temp = arr[j];
                    position = j;
                }
            }
            arr[position] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
