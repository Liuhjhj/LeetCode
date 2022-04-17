package dp;

/**
 * <a href="https://leetcode-cn.com/problems/coin-change-2/">零钱兑换-II</a>
 *
 * @author liuhj
 * @date 2022/1/12 21:47
 */
public class CoinChangePartTwo {

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount ; j++) {
                dp[j] += dp[j-coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        int change = change(amount, coins);
        System.out.println(change);
    }
}
