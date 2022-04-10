package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 背包问题-VIII
 * https://www.lintcode.com/problem/799/
 * 多重背包
 *
 * @author liuhj
 * @date 2022/1/8 20:39
 */
public class BackPackPartEight {

    public static int backPackVIII(int n, int[] value, int[] amount) {
        // write your code here
        int[] dp = new int[n + 1];
        List<Integer> value2 = new ArrayList<>(16);
        for (int i = 0; i < amount.length; i++) {
            int tempAmount = amount[i];
            for (int j = 1; j <= tempAmount; j *= 2) {
                tempAmount -= j;
                value2.add(value[i] * j);
            }
            if (tempAmount > 0) {
                value2.add(value[i] * tempAmount);
            }
        }
        for (Integer integer : value2) {
            for (int j = n; j >= integer; j--) {
                dp[j] = Math.max(dp[j], dp[j - integer] + integer);
            }
        }
        System.out.println(Arrays.toString(Arrays.stream(dp).skip(1).distinct().toArray()));
        return Arrays.stream(dp).skip(1).distinct().toArray().length;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] value = {1, 4};
        int[] amount = {2, 1};
        int i = backPackVIII(n, value, amount);
        System.out.println(i);
    }
}
