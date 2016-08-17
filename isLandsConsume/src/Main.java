import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/17.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int[][] distance = new int[num][num];
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    distance[i][j] = scanner.nextInt();
                }
            }
            System.out.println(distanceBridge(distance,0));
        }

    }

    public static int distanceBridge(int[][] distance,int i) {
        if (i >= distance.length - 1) {
            return 0;
        }
        else {
            int minDis = distance[i][i+1];
            for (int j = i+1; j < distance.length; j++) {
                if (distance[i][j] < minDis) {
                    minDis = distance[i][j];
                }
            }
            return minDis + distanceBridge(distance, i+1);
        }
    }
}
