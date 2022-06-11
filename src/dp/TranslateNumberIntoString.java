package dp;

/**
 * <a href="https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/">把数字翻译成字符串</a>
 *
 * @author liuhjhj
 * @date 2022/6/11
 **/
public class TranslateNumberIntoString {

    public int translateNum(int num) {
        String s = String.valueOf(num);
        if (s.length() == 0 || s.length() == 1) {
            return 1;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        if (Integer.parseInt(s.substring(0, 2)) >= 0 && Integer.parseInt(s.substring(0, 2)) <= 25) {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i < s.length(); i++) {
            dp[i] = dp[i - 1];
            int anInt = Integer.parseInt(s.substring(i - 1, i + 1));
            if (anInt >= 10 && anInt <= 25) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length() - 1];
    }
}
