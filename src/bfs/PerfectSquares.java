package bfs;

import java.util.*;

/**
 * 完全平方数
 * https://leetcode-cn.com/problems/perfect-squares/solution/
 * 知识点: 深/广度优先遍历, 动态规划
 *
 * @author liuhj
 * @date 2021/12/12 20:31
 */
public class PerfectSquares {

    public static int numSquaresBfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> layers = new LinkedList<>();
        Set<Integer> seen = new HashSet<>(8);
        queue.add(0);
        layers.add(0);
        seen.add(0);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int num = queue.remove();
            int layer = layers.remove();
            for (int i = 1; i * i <= n; i++) {
                int sum = num + (i * i);
                if (sum < n && !seen.contains(sum)) {
                    queue.add(sum);
                    layers.offer(layer + 1);
                    seen.add(sum);
                } else if (sum == n) {
                    return layer+1;
                } else if (sum > n) {
                    break;
                }
            }
        }
        return -1;
    }

    public static int numSquaresDp(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j*j<=i; j++) {
                int result = dp[i-j*j]+1;
                dp[i] = dp[i] == 0?result:Math.min(dp[i],result);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 999;
        int numSquares = numSquaresDp(n);
        System.out.println(numSquares);
    }
}
