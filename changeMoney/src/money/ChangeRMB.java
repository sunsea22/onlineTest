package money;

import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/30.
 * 我们知道人民币有1、2、5、10、20、50、100这几种面值。
 * 现在给你n(1≤n≤250)元，让你计算换成用上面这些面额表示且总数不超过100张，共有几种。
 *
 * 比如4元，能用4张1元、2张1元和1张2元、2张2元，三种表示方法。
 *
 * 找钱的面值只有7种：1，2，5，10，20，50，100；当输入一个n值介于某两个面值之间时，如n=25，则n介于20到50之间，
 * 那么所找钱的最大值为20；利用递归的思想，此时找钱的方法数可分为两类，一类是包含20面值，另一类是不包含20，
 * 利用加法原理，将两类相加即可。
 */
public class ChangeRMB {
    static int RMB[]={1,2,5,10,20,50,100};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        while (scanner.hasNext() && (n = scanner.nextInt()) != 0) {
            //index是指向第一个小于等于n值的RMB[i]的下标
            int index = 0;
            for (int i = 6; i >= 0; --i) {
                if (n >= RMB[i]) {
                    index = i;
                    break;
                }
            }
            System.out.println(findNum(n, index));
        }

    }

    private static int findNum(int n, int i) {
        if (n <= 1 || RMB[i] == 1) return 1;
        return findNum(n - RMB[i], i) + findNum(n, i-1);
    }
}
