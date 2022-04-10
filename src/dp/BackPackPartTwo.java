package dp;

import java.util.Arrays;

/**
 * 背包问题-II
 * https://www.lintcode.com/problem/125/
 *
 * @author liuhj
 * @date 2021/12/26 21:29
 */
public class BackPackPartTwo {

    public static int backPackII(int m, int[] weights, int[] values) {
        // 0-1背包问题
        // dp[i][j]为当背包容量为j时, 从前i个物品里面获取的最大价值
        int[][] dp = new int[values.length][m + 1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = weights[0] <= i ? values[0] : 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // 重量比背包容量j大, 不能拿第i个物品
                if (weights[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - weights[i]] + values[i], dp[i - 1][j]);
                }
            }
        }
        return dp[weights.length - 1][m];
    }

    public static void main(String[] args) {
        int maxWeight = 10;
        int[] weights = {2, 3, 8};
        int[] values = {2, 5, 8};
        int i = backPackII(maxWeight, weights, values);
        System.out.println(i);
    }
}
