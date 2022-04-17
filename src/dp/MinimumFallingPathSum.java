package dp;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/minimum-falling-path-sum/">下降路径最小和</a>
 *
 * @author liuhj
 * @date 2021/12/25 23:29
 */
public class MinimumFallingPathSum {

    public static int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        System.arraycopy(matrix[0], 0, dp[0], 0, matrix[0].length);
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
                } else if (j == matrix[0].length - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])) + matrix[i][j];
                }
            }
        }
        int min = dp[matrix.length - 1][0];
        for (int i = 1; i < matrix[0].length; i++) {
            min = Math.min(min, dp[matrix.length - 1][i]);
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        int i = minFallingPathSum(matrix);
        System.out.println(i);
    }
}
