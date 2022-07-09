package array;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/">最长的斐波那契子序列的长度</a>
 * <p>知识点: 动态规划</p>
 *
 * @author liuhjhj
 * @date 2022/7/9 上午12:13
 */
public class LengthOfLongestFibonacciSubsequence {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        /// int[] arr = {1, 3, 7, 11, 12, 14, 18};
        int i = lenLongestFibSubseq(arr);
        System.out.println(i);
    }

    public static int lenLongestFibSubseq(int[] arr) {
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>((int) (arr.length / 0.75f + 1));
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int[][] dp = new int[arr.length][arr.length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j--) {
                int index = map.getOrDefault(arr[i] - arr[j], -1);
                if (index > 0) {
                    dp[j][i] = Math.max(dp[index][j] + 1, 3);
                }
                result = Math.max(result, dp[j][i]);
            }
        }
        return result;
    }
}
