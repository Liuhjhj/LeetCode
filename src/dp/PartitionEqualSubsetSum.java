package dp;

import java.util.Arrays;

/**
 * 分割等和子集
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 *
 * @author liuhj
 * @date 2022/1/12 21:36
 */
public class PartitionEqualSubsetSum {

    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1 || nums.length == 1) {
            return false;
        }
        int[] dp = new int[sum / 2 + 1];
        for (int num : nums) {
            for (int j = dp.length - 1; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }
        return dp[sum / 2] == sum / 2;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 9};
        boolean b = canPartition(nums);
        System.out.println(b);
    }
}
