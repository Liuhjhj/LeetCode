package string;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 反转字符串中的单词-III
 * https://leetcode-cn.com/leetbook/read/array-and-string/c8su7/
 *
 * @author liuhj
 * @date 2021/12/11 15:24
 */
public class ReverseWordPartThree {

    public static String reverseWords(String s) {
        String[] strings = s.split(" ");
        return Arrays.stream(strings).filter(string -> string.length() > 0).map(string -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = string.length() - 1; i >= 0; i--) {
                stringBuilder.append(string.charAt(i));
            }
            stringBuilder.append(" ");
            return stringBuilder.toString();
        }).collect(Collectors.joining()).trim();
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String reverseWords = reverseWords(s);
        System.out.println(reverseWords);
    }
}
