import java.util.Scanner;

/**
 * Created by Sunsea on 16/9/3.
 * dijistra算法
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] talk = new int[n+1];
            int[][] path = new int[n+1][n+1];
            //初始化距离矩阵，刚开始所有站点之间的距离为无穷大
            init(path, n);
            for (int i = 1; i <= n; i++) {
                talk[i] = scanner.nextInt();
            }
            for (int i = 0; i < m; i++) {
                //将最后M行的输入转化为距离矩阵
                int p = scanner.nextInt();
                int q = scanner.nextInt();
                path[p][q] = talk[q];
                path[q][p] = talk[p];
            }
            System.out.println(pickupNum(n,1,talk[1],path));
        }
        scanner.close();
    }

    private static void init(int[][] road, int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                road[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    private static int pickupNum(int n, int s, int talk1, int[][] path) {
        int[] dist = new int[n+1];
        boolean[] isVisited = new boolean[n+1];
        for (int i = 2; i <= n; i++) { //起点车站到各车站的距离
            dist[i] = path[s][i];
        }
        dist[s] = talk1;
        isVisited[s] = true;

        for (int i = 2; i < n; i++) {
            int minDist = Integer.MAX_VALUE;
            int v = 1;
            for (int j = 1;j <= n; j++) {
                if (!isVisited[j]&&dist[j] < minDist) {
                    minDist = dist[j];
                    v = j;
                }
            }
            //找到距离初始站台最近的站台
            isVisited[v] = true;

            for (int j = 1; j <= n; j++) {
                if (!isVisited[j] && path[v][j] < Integer.MAX_VALUE) {
                    //两种情况：一种是由初始点到达V点再到达j点，另一种是初始点直接到达j点，两者去最小值
                    int temp = dist[v] + path[v][j];
                    dist[j] = dist[j] < temp ? dist[j] : temp;
                }
            }
        }
        return dist[n] + talk1;
    }
}
