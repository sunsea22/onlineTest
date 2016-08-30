package coin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sunsea on 16/8/30.
 * 问题描述：
    现存在一堆面值为 V1、V2、V3 … 个单位的硬币，问最少需要多少个硬币才能找出总值为 T 个单位的零钱？
 解题思路：
    1，找出面值最接近T的硬币V
    2，将f(T)问题的求解转换成f(T-V)+1问题的求解，以此出现递归
 */
public class CoinChange {
    public static void main(String[] args) {
        CoinChange coinChange=new CoinChange();
        int res=coinChange.coinNum(new int[]{1,2,3,5,11},81);
        System.out.println(res);
    }

    /**
     * 获取找零硬币个数
     * @param coinValue 硬币的面值
     * @param totalValue 需要找零的钱数
     * @return
     */
    public int coinNum(int[] coinValue, int totalValue) {
        List<Integer> coins = new ArrayList<>();
        coins.add(0);

        for (int i = 1; i <= totalValue; i++) {
            int coin = nearestCoin(i, coinValue);
            int coinNum = coins.get(i - coin) + 1;
            coins.add(coinNum);
        }
        return coins.get(totalValue);
    }

    /**
     * 获取最接近找近零钱的硬币面值
     * @param value
     * @param coinValues
     * @return
     */
    private int nearestCoin(int value, int[] coinValues) {
        int res = 0;
        int nearest = Integer.MAX_VALUE;
        for (int coinValue: coinValues) {
            if (coinValue <= value) {
                int distance = value - coinValue;
                if (distance < nearest) {
                    nearest = distance;
                    res = coinValue;
                }
            }
        }
        return res;
    }
}
