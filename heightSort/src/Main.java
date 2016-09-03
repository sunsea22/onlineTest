/**
 * Created by Sunsea on 16/9/3.
 * 阿里巴巴的面试题
 * 12个高矮不同的人,排成两排,每排必须是从矮到高排列,而且第二排比对应的第一排的人高,问排列方式有多少种?
 *
 * 问题分析:
 *我们先把这12个人从低到高排列,然后,选择6个人排在第一排,那么剩下的6个肯定是在第二排.
 * 用0表示对应的人在第一排,用1表示对应的人在第二排,那么含有6个0,6个1的序列,就对应一种方案.
 * 比如000000111111就对应着
 * 第一排：0 1 2 3 4 5
 * 第二排：6 7 8 9 10 11
 * 010101010101就对应着
 * 第一排：0 2 4 6 8 10
 * 第二排：1 3 5 7 9 11
 * 问题转换为，这样的满足条件的01序列有多少个。
 */
public class Main {
    public static void main(String[] args) {
        int[] F = new int[6];
        int[] B = new int[6];
        int i, j, state, ok, ans = 0;

        for (state = 0; state < (1 << 12); ++state) { //12位一共有这么多的数
            if (bit_cnt(state) == 6) { //如果有6个1则符合
                i = j = 0;
                for (int k = 0; k < 12; ++k) {
                    if ((state & (1 << k)) == 0) //判断对应为是否为1
                        F[i++] = k;
                    else
                        B[j++] = k;
                }
                ok = 1;
                for (int k = 0; k < 6; ++k) {
                    if (B[k] < F[k]) { //B和F分别是从小到大排的，只要检查对应位置的相对大小是否符合要求即可
                        ok = 0;
                        break;
                    }
                }
                ans += ok;
            }
        }
        System.out.println(ans);
    }

    private static int bit_cnt(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }
}
