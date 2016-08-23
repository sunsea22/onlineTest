import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/23.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int[][] matrix = new int[row][col];

            for (int i = 0; i < row * col; i++) {
                matrix[i / col][i % col] = scanner.nextInt();
            }

            System.out.println(mazeWayFind(matrix));
        }
    }

    private static String mazeWayFind(int[][] matrix) {
        List<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        boolean[] find = new boolean[1];
        wayFinding(matrix, 0, 0, visited, find, result);

        StringBuilder res = new StringBuilder();

        for (String s: result) {
            res.append(s).append("\n");
        }

        //去掉最后一个换行符
        res.deleteCharAt(res.length() - 1);

        return res.toString();

    }

    /**
     *
     * @param matrix 迷宫
     * @param x 当前的行号
     * @param y 当前的列号
     * @param visited 标记某个位置是否被访问过了
     * @param find 是否已经找到
     * @param result 路径标识
     */
    private static void wayFinding(int[][] matrix, int x, int y, boolean[][] visited, boolean[] find, List<String> result) {
        if (find[0]) {
            return;
        }

        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] == 1 || visited[x][y]) {
            return;
        }

        if (x == matrix.length - 1 && y == matrix[0].length - 1 && matrix[x][y] == 0) {
            find[0] = true;
            visited[x][y] = true;

            result.add("(" + x + "," + y + ")");
        }

        else {
            visited[x][y] = true;
            result.add("(" + x + "," + y + ")");

            wayFinding(matrix, x, y + 1, visited, find, result);
            if (find[0]) {
                return;
            }

            wayFinding(matrix, x - 1, y, visited, find, result);
            if (find[0]) {
                return;
            }

            wayFinding(matrix, x, y - 1, visited, find, result);
            if (find[0]) {
                return;
            }

            wayFinding(matrix, x + 1, y, visited, find, result);
            if (find[0]) {
                return;
            }

            //还原
            visited[x][y] = false;
            result.remove(result.size() - 1);
        }
    }
}
