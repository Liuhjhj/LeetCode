package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/">最长不含重复字符的子字符串</a>
 *
 * @author liuhjhj
 * @date 2022/6/11
 **/
public class LongestWithoutRepetitionString {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len <= 1){
            return len;
        }
        Map<Character, Integer> map = new HashMap<>((int) (s.length() / 0.75f + 1));
        int[] dp = new int[len];
        dp[0] = 1;
        map.put(s.charAt(0), 0);
        int result = dp[0];
        int start;

        for (int end = 1; end < len; end++) {
            start = map.getOrDefault(s.charAt(end), -1);
            map.put(s.charAt(end), end);
            // 当start为-1时, 说明没有重复的字串, 可以+1
            if (dp[end - 1] < end - start) {
                dp[end] = dp[end - 1] + 1;
            } else {
                // 否则字串长度为end - start
                dp[end] = end - start;
            }
            result = Math.max(result, dp[end]);
        }
        return result;
    }
}
