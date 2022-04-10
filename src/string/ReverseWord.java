package string;

import java.util.Arrays;

/**
 * 翻转字符串中的单词
 * https://leetcode-cn.com/leetbook/read/array-and-string/crmp5/
 *
 * @author liuhj
 * @date 2021年12月5日13:58:44
 */
public class ReverseWord {

    public static String reverseWords(String s) {
        int fast;
        int slow = -1;
        // 去掉头部和尾部的空格
        s = s.trim();
        if (s.length() == 0) {
            return s;
        }
        // 去掉每个单词之间多余的空格, 使每个单词之间只有一个空格
        for (int i = 0; i < s.length() - 1; ) {
            if (s.charAt(i) == ' ' && s.charAt(i + 1) == ' ') {
                s = s.substring(0, i) + s.substring(i + 1);
                continue;
            }
            i++;
        }
        // 记录下最后一个字符的位置
        int lastCharLocation = s.length();
        for (int i = 0; lastCharLocation >= 0 && i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                if (slow == -1) {
                    slow = i;
                }
            } else {
                if (i - 1 >= 0 && s.charAt(i - 1) != ' ') {
                    fast = i;
                    // 将字符串的第一个单词插到原字符串最后一个单词的后面
                    s = s.substring(0, lastCharLocation) + " " + s.substring(slow, fast) + s.substring(lastCharLocation);
                    // 去掉字符串的第一个单词以及单词后面的空格
                    s = s.substring(fast + 1);
                    // 重新记录原来字符串的最后一个字符的位置
                    lastCharLocation = lastCharLocation - fast + slow - 1;
                    slow = -1;
                    // 重置下标, 又从0开始循环
                    i = -1;
                }
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "";
        String reverseWords = reverseWords(s);
        System.out.println(reverseWords);
    }
}