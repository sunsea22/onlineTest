import java.util.Scanner;

/**
 * Created by Sunsea on 16/9/5.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String a = scanner.next();
            String b = scanner.next();
            int c0 = scanner.nextInt();
            int c1 = scanner.nextInt();
            int c2 = scanner.nextInt();
            System.out.println(findMinCost(a,b,c0,c1,c2));
        }
        scanner.close();
    }

    private static int findMinCost(String a, String b, int c0, int c1, int c2) {
        int[][] dp = new int[a.length()+1][b.length()+1];

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + c1;
        }

        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = dp[0][j-1] + c0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j-1] + c2, Math.min(dp[i][j-1] + c0, dp[i-1][j] + c1));
                }
            }
        }
        if (a.equals(b)) {
            return 0;
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
