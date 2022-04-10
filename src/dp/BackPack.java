package dp;

import java.util.Arrays;

/**
 * 背包问题
 * https://www.lintcode.com/problem/92/
 * 0-1背包
 *
 * @author liuhj
 * @date 2021/12/26 20:41
 */
public class BackPack {

    public static int backPack(int m, int[] A) {
        // 0-1背包问题
        // dp[i][j]为当背包容量为j的时候, 从前i个物品中选出的最大的重量
        int[][] dp = new int[A.length][m + 1];
        for (int i = 0; i < dp[0].length; i++) {
            if (A[0] <= i) {
                dp[0][i] = A[0];
            } else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // 重量比背包容量j大, 不能拿第i个物品
                if (A[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - A[i]] + A[i], dp[i - 1][j]);
                }
            }
        }
        return dp[A.length - 1][m];
    }

    public static void main(String[] args) {
        int m = 10;
        int[] a = {3, 4, 8, 5};
        int i = backPack(m, a);
        System.out.println(i);
    }
}
