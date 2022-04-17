package dfs;

/**
 * <a href="https://leetcode-cn.com/problems/target-sum/">目标之和</a>
 * <p>知识点: 深/广度优先遍历, 动态规划</p>
 *
 * @author liuhj
 * @date 2021/12/25 17:54
 */
public class TargetSum {
    static int count;

    public static int findTargetSumWays(int[] nums, int target) {
        // 设数组元素和为sum, 前面带-号的元素和为neg
        // 则带+号的元素和pos = sum-neg
        // 那么target = pos - neg = sum - 2 * neg
        // sum - 2 * neg = target
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < target || (sum - target) % 2 != 0) {
            return 0;
        }
        int neg = (sum - target) / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = neg; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[(sum - target) / 2];
    }

    public static void dfs(int[] nums, int index, int target, int sum) {
        if (index >= nums.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        dfs(nums, index + 1, target, sum + nums[index]);
        dfs(nums, index + 1, target, sum - nums[index]);
    }

    public static void main(String[] args) {
        /// int[] nums = {1, 1, 1, 1, 1};
        /// int target = 3;
        int[] nums = {1, 0};
        int target = 1;
        findTargetSumWays(nums, target);
        System.out.println(count);
    }
}
