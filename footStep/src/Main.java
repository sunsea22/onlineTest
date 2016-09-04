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
            System.out.println(conutWays1(n));
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

    /**
     * 现在有一栋高楼，但是电梯却出了故障，无奈的你只能走楼梯上楼，根据你的腿长，
     * 你一次能走1级或2级楼梯，已知你要走n级楼梯才能走到你的目的楼层，
     * 请计算你走到目的楼层的方案数，由于楼很高，所以n的范围为int范围内的正整数。
     * 给定楼梯总数n，请返回方案数。为了防止溢出，请返回结果Mod 1000000007的值。
     * @param n
     * @return
     */
    private static int conutWays1(int n) {
        if (n == 0 || n == 1) return 1;
        long[][] res = {{1,0},{0,1}};
        long[][] basic = {{1,1},{1,0}};
        int iter = n-1;
        while (iter > 1) {
            if ((iter&1) == 1) {
                res = mutiply(res, basic);
            }
            basic = mutiply(basic, basic);
            iter >>>= 1;
        }
        basic = mutiply(res, basic);
        return (int)(basic[0][0] + basic[1][0])%1000000007;
    }

    private static long[][] mutiply(long[][] a, long[][] b) {
        long[][] res = new long[2][2];
        res[0][0] = (a[0][0]*b[0][0] + a[0][1]*b[1][0])%1000000007;
        res[0][1] = (a[0][0]*b[0][1] + a[0][1]*b[1][1])%1000000007;
        res[1][0] = (a[1][0]*b[0][0] + a[1][1]*b[1][0])%1000000007;
        res[1][1] = (a[1][0]*b[0][1] + a[1][1]*b[1][1])%1000000007;
        return res;
    }
}
