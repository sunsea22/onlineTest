import java.util.Scanner;

/**
 * Created by Sunsea on 16/9/4.
 * 递推公式：F(n)=F(n-1)+F(n-3)
 * 快速幂乘矩阵算法
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(cowNum(n));
        }

        scanner.close();
    }

    private static int cowNum(int n) {
        if (n < 5)
            return n;
        long[][] matrix = {{1,0,0},{0,1,0},{0,0,1}};
        long[][] basic = {{1,0,1},{1,0,0},{0,1,0}};
        int iter = n;
        while (iter > 1) {
            if ((iter&1) == 1) {
                matrix = mutiMatrix(matrix, basic);
            }
            basic = mutiMatrix(basic, basic);
            iter >>>= 1;
        }
        basic = mutiMatrix(matrix, basic);
        return (int)(basic[0][0] + basic[2][0])%1000000007;
    }

    private static long[][] mutiMatrix(long[][] a, long[][] b) {
        long[][] res = new long[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    res[i][j] = (res[i][j] + a[i][k]*b[k][j])%1000000007;
                }
            }
        }
        return res;
    }
}
