package dp;

/**
 * 最长递增子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * @author liuhj
 * @date 2021/12/25 23:14
 */
public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] == 0) {
                dp[i] = 1;
            }
        }
        int max = 0;
        for (int dp_int : dp) {
            max = Math.max(dp_int, max);
        }
        return max;
    }

    public static void main(String[] args) {
        /// int[] nums = {4,10,4,3,8,9};
        /// int[] nums = {10,9,2,5,3,7,101,18};
        /// int[] nums = {0,1,0,3,2,3};
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }
}
