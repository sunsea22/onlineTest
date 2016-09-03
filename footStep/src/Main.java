import java.util.Scanner;

/**
 * Created by Sunsea on 16/9/3.
 * 有一楼梯共m级，刚开始时你在第一级，若每次只能跨上一级或者二级，要走上m级，共有多少走法？注：规定从一级到一级有0种走法。
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100。为了防止溢出，请返回结果Mod 1000000007的值。
 * 测试样例：
 * 3
 * 返回：2
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(countWays(n));
        }
        scanner.close();
    }

    private static int countWays(int n) {
        if (n == 1)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int a = 1, b = 2, i = 3;
        while (i < n) {
            b = (a+b) % 1000000007;
            a = (b - a + 1000000007) % 1000000007;
            i++;
        }
        return b;
    }
}
