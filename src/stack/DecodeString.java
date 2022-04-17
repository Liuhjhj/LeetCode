package stack;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/decode-string/">字符串解码</a>
 *
 * @author liuhj
 * @date 2022/1/14 20:13
 */
public class DecodeString {

    public static String decodeString(String s) {
        Stack<Character> characters = new Stack<>();
        Stack<Integer> num = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ']') {
                if (ch >= '0' && ch <= '9') {
                    int j = i;
                    StringBuilder temp = new StringBuilder();
                    while (s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                        temp.append(s.charAt(j));
                        j++;
                    }
                    i = j - 1;
                    num.push(Integer.valueOf(temp.toString()));
                } else {
                    characters.push(ch);
                }
            } else {
                char top = characters.pop();
                StringBuilder sb = new StringBuilder();
                while (top != '[') {
                    sb.append(top);
                    top = characters.pop();
                }
                sb.reverse();
                int tempNum = num.pop();
                StringBuilder sb2 = new StringBuilder();
                for (int j = 0; j < tempNum; j++) {
                    sb2.append(sb);
                }
                for (int j = 0; j < sb2.length(); j++) {
                    characters.push(sb2.charAt(j));
                }
            }
        }
        StringBuilder result = new StringBuilder();
        while (!characters.isEmpty()) {
            result.append(characters.pop());
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        /// String string = "3[a]2[bc]";
        /// String string = "2[abc]3[cd]ef";
        /// String string = "3[a2[c]]";
        String string = "3[2[a3[b]c]d]";
        /// String string = "10[a]";
        String s = decodeString(string);
        System.out.println(s);
    }
}
