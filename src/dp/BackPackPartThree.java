package dp;

/**
 * <a href="https://www.lintcode.com/problem/440/">背包问题-III</a>
 * <p>知识点: 完全背包</p>
 *
 * @author liuhj
 * @date 2022/1/12 22:12
 */
public class BackPackPartThree {

    public int backPackIII(int[] A, int[] V, int m) {
        // write your code here
        int[] dp = new int[m+1];
        for (int i = 0; i < A.length; i++){
            for(int j = A[i]; j<=m; j++){
                dp[j] = Math.max(dp[j],dp[j-A[i]]+V[i]);
            }
        }
        return dp[m];
    }
}
