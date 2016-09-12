import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Sunsea on 16/9/11.
 * 可以考虑用回溯法解决该问题，第i天选取符合条件的和尚j挑水，则和尚j不能在其他的天里挑水，
 * 设置visited[j]=1，第i+1天若存在可挑水的和尚，则选取，若不存在，则返回第i天，选取非j和尚挑水。可以利用递归来实现回溯。
 */
public class Main {
    static int[][] M = new int[8][8];
    static int sum = 0;
    static ArrayList<Integer> allArranges = new ArrayList<>(); //用来存储所有安排方案
    static Integer arrange[] = new Integer[8]; //存储当前单个方案
    static int[] visited = new int[8]; //visited[i]的值描述地i个和尚是否被访问过，1表示已被访问，0表示未被访问；

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                M[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        for (int i = 1; i < 8; i++) {
            arrange[i] = 0;
            visited[i] = 0;
        }
        backTrack(1);

        System.out.print(sum + "\n");

        for (int i = 0; i < sum; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(allArranges.get(i*7+j) + " ");
            }
            System.out.println();
        }
    }

    static void backTrack(int t) {
        if (t == 8) {
            for (int i = 1; i < 8; i++) {
                allArranges.add(arrange[i]);
            }
            sum++;
        }
        else {
            for (int i = 1; i < 8; i++) {
                if (visited[i] == 0 && M[i][t] == 1) {
                    arrange[t] = i;
                    visited[i] = 1;
                    backTrack(t+1);
                    visited[i] = 0;
                }
            }
        }
    }
}
