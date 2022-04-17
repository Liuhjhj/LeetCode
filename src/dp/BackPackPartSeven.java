package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://www.lintcode.com/problem/798/">背包问题-VII</a>
 * <p>知识点: 多重背包</p>
 *
 * @author liuhj
 * @date 2022/1/5 20:03
 */
public class BackPackPartSeven {
    public static int backPackVII(int n, int[] prices, int[] weight, int[] amounts) {
        // 多重背包问题
        int[] dp = new int[n + 1];
        List<Integer> weight2 = new ArrayList<>(16);
        List<Integer> prices2 = new ArrayList<>(16);
        for (int i = 0; i < amounts.length; i++) {
            int tempAmount = amounts[i];
            for (int j = 1; j < tempAmount; j *= 2) {
                tempAmount -= j;
                weight2.add(weight[i] * j);
                prices2.add(prices[i] * j);
            }
            if (tempAmount > 0) {
                weight2.add(weight[i] * tempAmount);
                prices2.add(prices[i] * tempAmount);
            }
        }
        for (int i = 0; i < weight2.size(); i++) {
            for (int k = n; k >= prices2.get(i); k--) {
                dp[k] = Math.max(dp[k], dp[k - prices2.get(i)] + weight2.get(i));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int money = 8;
        int[] prices = {3, 2};
        int[] weight = {300, 160};
        int[] amount = {1, 6};
        int i = backPackVII(money, prices, weight, amount);
        System.out.println(i);
    }
}
