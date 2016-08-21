import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/21.
 * 1、题目
 现有一组砝码，重量互不相等，分别为m1、m2……mn；他们可取的最大数量分别为x1、x2……xn。现在要用这些砝码去称物体的重量，问能称出多少中不同的重量。

 注：
 称重重量包括0
 要对输入数据进行校验
 转载:http://blog.csdn.net/u012296503/article/details/51232365
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int[] a = new int[num];
            int[] b = new int[num];
            for (int i = 0; i < num; i++) {
                a[i] = scanner.nextInt();
            }
            for (int i = 0; i < num; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(countNum(a,b));
        }
        scanner.close();
    }

    private static int countNum(int[] a, int[] b) {
        //0也包括在内，所以即使没有砝码，也存在一种情况
        int total = 1;

        for (int i = 0; i < a.length; i++) {
            total += a[i]*b[i];
        }

        //声明一个标记数组，用于标记砝码可以组合出来的值
        boolean[] flag = new boolean[total];

        //取第一种砝码，并对组合的重量进行标记
        for (int j = 0; j <= b[0]; j++) {
            flag[a[0]*j] = true;
        }

        //将第一种砝码标记完的各种组合之后，记录下重量
        total = a[0]*b[0];

        int sum = 0;
        //从第二种砝码开始取
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j <= b[i]; j++) {
                for (int k = 0; k <= total; k++) {
                    sum = k + j*a[i];

                    //如果和大于标记数组长度则跳出当前循环
                    if (sum > flag.length) {
                        break;
                    }

                    //如果是第二个砝码重量的整数倍（不大于砝码的个数）直接标记，如果k位已标记加上0~n个砝码的重量未标记，则进行标记
                    //k == 0直接进行标记是因为每次不同重量的砝码第一个加入时，都可以成为一种新的重量(不管前面有没有标记)
                    if (flag[k] && !flag[sum] || k == 0) {
                        flag[sum] = true;
                    }
                }
            }
            // 将本次放入一种砝码与之前的累加总和赋值给total
            total = sum;
        }
        int count = 0;
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == true) {
                count++;
            }
        }
        return count;
    }
}
