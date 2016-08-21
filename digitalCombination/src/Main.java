import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/21.
 * 题目：5个砝码　　用天平称重时，我们希望用尽可能少的砝码组合称出尽可能多的重量。　　如果只有5个砝码，重量分别是1，3，9，27，81。则它们可以组合称出1到121之间任意整数重量（砝码允许放在左右两个盘中）。　　本题目要求编程实现：对用户给定的重量，给出砝码组合方案。　　
 例如：　　
 用户输入：5　　
 程序输出：9-3-1　　
 用户输入：19　　
 程序输出：27-9+1　　　　
 要求程序输出的组合总是大数在前小数在后。可以假设用户的输入的数字符合范围1~121。

 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            System.out.println(combination(input));
        }
        scanner.close();
    }

    private static String combination(int input) {
        StringBuilder res = new StringBuilder();
        int[] b = {1,3,9,27,81};
        int[] a = new int[5];

        for (int j = 0; j < 5; j++) {
            a[j] = 0;
        }
        int i = 0;

        while (input > 0) {
            a[i++] = input % 3;
            input = input / 3;
        }

        for (int j = 0; j < i; j++) { //i没有在这之前减1是因为会有进位
            switch (a[j]) {
                case 2:
                    a[j] = -1;
                    a[j+1]++;
                    break;
                case 3:
                    a[j] = 0;
                    a[j+1]++;
            }
        }

        i--; //先进行了加，然后再判断input是否大于0，所以这里要减1

        for (int j = i; j >= 0; j--) {
            if (j == i) {
                if (i < 4 && a[j+1] != 0) { //检验最高位的前一位是否为0（此时i应该小于4，若等于4则直接输出）
                    res.append(a[j+1]*b[j+1]);
                    if (a[j]*b[j] != 0)
                        res.append(a[j]*b[j]);
                }
                else res.append(a[j]*b[j]); //等于4直接输出
            }
            else {
                int num = a[j]*b[j];
                if (num > 0)
                    res.append("+" + num);
                else if (num < 0)
                    res.append(num);
            }
        }
        return res.toString();
    }
}
