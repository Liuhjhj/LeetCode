package string;

/**
 * <a href="https://leetcode-cn.com/leetbook/read/array-and-string/conm7/">最长回文子串</a>
 * <p>知识点: 动态规划</p>
 *
 * @author liuhj
 * @date 2021年12月4日19:27:25
 */
public class LongestPalindromicSubstring {

    /**
     * 构建一个二维布尔数组, 其中dp[i][j]表示从下标i到j是否是一个回文子串
     * 一个回文子串(长度大于2)去掉头和尾的字符后, 必定还是一个回文子串
     * 以此就有dp[i][j] = dp[i+1][j-1] && string[i] == string[j]
     *
     * @param s 待查找的字符串
     * @return 最长回文子串
     */
    public static String longestPalindrome(String s) {
        if (s.length() == 1|| s.length()==0){
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int resultIndexStart = 0;
        int resultIndexEnd = 0;
        int resultLength = 0;
        // 边界值
        for (int i = 0; i < s.length(); i++) {
            // 单个字符必定是回文子串
            dp[i][i] = true;
            if (i < s.length() - 1) {
                // 两个相等的相邻字符也是回文子串
                dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
                if (dp[i][i + 1] && resultLength < 1) {
                    resultLength = 1;
                    resultIndexStart = i;
                    resultIndexEnd = i + 1;
                }
            }
        }
        // 纵向遍历二维布尔数组的上半部分, 因为对于dp[i][j]始终有i<=j
        // 从dp[0][2]开始遍历
        for (int i = 2; i < s.length(); i++) {
            for (int j = 0; j < i - 1; j++) {
                dp[j][i] = dp[j + 1][i - 1] && s.charAt(j) == s.charAt(i);
                if (dp[j][i] && i-j>resultLength){
                    resultLength = i-j;
                    resultIndexStart = j;
                    resultIndexEnd = i;
                }
            }
        }
        return s.substring(resultIndexStart,resultIndexEnd+1);
    }

    public static void main(String[] args) {
        String s = "aaabaaaa";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }
}
