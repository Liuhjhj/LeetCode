package dp;

/**
 * 背包问题-V
 * https://www.lintcode.com/problem/563/
 * 0-1背包
 *
 * @author liuhj
 * @date 2021/12/29 22:01
 */
public class BackPackPartFive {

    public static int backPackV(int[] nums, int target) {
        // 0-1背包问题
        // dp[i][j]表示当背包容量为j时, 从前i个物品中选出能恰好装满背包的方案数
        // 当背包容量为0时, dp[i][0]等于1, 因为容量为0的时候什么也不用做, 背包就是满的
        int[][] dp = new int[nums.length][target + 1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = nums[0] == i ? 1 : 0;
        }
        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i]) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][target];
    }

    public static void main(String[] args) {
        ///int[] nums = {1,1,1,1};
        ///int target = 3;
        int[] nums = {1, 2, 3, 3, 7};
        int target = 3;
        int i = backPackV(nums, target);
        System.out.println(i);
    }
}
