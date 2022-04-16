package string;

import java.util.*;

/**
 * 迷你语法分析器
 * <p>
 * <a href="https://leetcode-cn.com/problems/mini-parser/">https://leetcode-cn.com/problems/mini-parser/</a>
 * </p>
 *
 * @author liuhjhj
 * @date 2022/4/16
 **/
public class MiniParser {

    static class NestedInteger {
        List<NestedInteger> list;

        Integer value;

        public NestedInteger() {
            list = new ArrayList<>(16);
        }

        public NestedInteger(Integer value) {
            this.value = value;
        }

        public NestedInteger(List<NestedInteger> list) {
            this.list = list;
        }

        public boolean isInteger() {
            return value != null;
        }

        public Integer getInteger() {
            return value;
        }

        public List<NestedInteger> getList() {
            return list;
        }

        public void add(NestedInteger nestedInteger) {
            list.add(nestedInteger);
        }
    }

    public static void main(String[] args) {
        MiniParser miniParser = new MiniParser();
        /// NestedInteger nestedInteger = miniParser.deserialize("[123,[456,[789]]]");
        /// NestedInteger nestedInteger = miniParser.deserialize("[0,[123]]");
        /// NestedInteger nestedInteger = miniParser.deserialize("[[]]");
        /// NestedInteger nestedInteger = miniParser.deserialize("[123,456,[788,799,833],[[]],10,[]]");
        NestedInteger nestedInteger = miniParser.deserialize("[[],[[[[]],-4],[[[]],[0],[[]]]]]");
        System.out.println("[" + nestedInteger + "]");
    }

    public NestedInteger deserialize(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.valueOf(s));
        }
        s = s.substring(1, s.length() - 1);
        return recursion(s);
    }

    public NestedInteger recursion(String s) {
        NestedInteger nestedInteger = new NestedInteger();
        if (s.length() == 0) {
            return nestedInteger;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isNumber(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < s.length() && isNumber(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }
                nestedInteger.add(new NestedInteger(Integer.valueOf(sb.toString())));
            }
            if (c == '[') {
                i++;
                int leftBracket = 1;
                StringBuilder sb = new StringBuilder();
                while (i < s.length() && leftBracket != 0) {
                    if (s.charAt(i) == '[') {
                        leftBracket++;
                    } else if (s.charAt(i) == ']') {
                        leftBracket--;
                    }
                    if (leftBracket != 0) {
                        sb.append(s.charAt(i));
                    }
                    i++;
                }
                nestedInteger.add(recursion(sb.toString()));
            }
        }
        return nestedInteger;
    }

    public boolean isNumber(char c) {
        return c == '-' || (c >= '0' && c <= '9');
    }
}
