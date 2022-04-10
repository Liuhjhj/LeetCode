package bfs;

import java.util.*;

/**
 * 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 * 知识点: 深/广度优先遍历, 动态规划
 *
 * @author liuhj
 * @date 2021/12/12 22:07
 */
public class CoinChange {

    public static int coinChangeDp(int[] coins, int amount) {
        coins = Arrays.stream(coins).sorted().toArray();
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static int coinChangeBfs(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        queue.add(0);
        int coinCount = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            coinCount++;
            for (int i = 0; i < size; i++) {
                Integer curCoin = queue.remove();
                for (int coin : coins) {
                    if (coin + curCoin < amount && !seen.contains(coin + curCoin)) {
                        queue.add(coin + curCoin);
                        seen.add(coin + curCoin);
                    } else if (coin + curCoin == amount) {
                        return coinCount + 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        /// int[] coins = {186, 419, 83, 408};
        /// int amount = 6249;
        int[] coins = {2, 3};
        int amount = 1;
        int coinChange = coinChangeBfs(coins, amount);
        System.out.println(coinChange);
    }
}
