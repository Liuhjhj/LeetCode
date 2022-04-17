package dp;

/**
 * <a href="https://www.lintcode.com/problem/562/">背包问题-IV</a>
 * <p>知识点: 完全背包</p>
 *
 * @author liuhj
 * @date 2022/1/12 22:16
 */
public class BackPackPartFour {

    public int backPackIV(int[] nums, int target) {
        // write your code here
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i=0; i<nums.length; i++){
            for(int j = nums[i]; j<=target; j++){
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}
