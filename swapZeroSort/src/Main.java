/**
 * Created by Sunsea on 16/9/1.
 * 和0交换的排序
 * 一个整数组里包含0-（n-1）的排列（0到n-1恰好只出现一次）
 * 如果每次只允许把任意数和0交换，求排好顺序至少交换多少次
 *
 * 组合数学里的圈
 * 1. 一个长度为m的圈，如果包含0，则交换m-1次可以恢复所有的数到原位
 * 2. 如果一个长度为m的圈不包含0，则交换m+1次可以恢复所有的数到原位
 */
public class Main {
    static int[] a = {2,3,0,1};
    public static void main(String[] args) {
        int answer = 0;
        for (int i = 0; i < a.length; ++i) {
            answer += sortTimes(a[i]);
        }
        System.out.println(answer);
    }

    private static int sortTimes(int x) {
        int len = a.length;
        boolean[] mark = new boolean[len]; //标记数组

        int r = 0;
        boolean have = false;

        for (; !mark[x]; ++r) {
            //0是否在圈内
            if (x == 0) {
                have = true;
            }
            mark[x] = true;
            x = a[x];
        }
        return have ? (r - 1) : ((r <= 1) ? 0 : (r + 1));
    }
}
