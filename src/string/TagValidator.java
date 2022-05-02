package string;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <a href="https://leetcode-cn.com/problems/tag-validator/">标签验证器</a>
 *
 * @author liuhjhj
 * @date 2022/5/2
 **/
public class TagValidator {

    public static void main(String[] args) {
        System.out.println(isValid("<A></A>"));
    }

    public static boolean isValid(String code) {
        Stack<String> stack = new Stack<>();

        // 根标签只能有一个
        if (code.startsWith("<![CDATA[") || code.endsWith("]]>")) {
            return false;
        }

        // 去掉<![CDATA[*]]>
        while (code.contains("<![CDATA[")) {
            String temp = code;
            int start = code.indexOf("<![CDATA[");
            temp = temp.substring(start);
            int end = temp.indexOf("]]>") + 3 + start;
            // 替换为空格, 防止<![CDATA[*]]>出现在标签里面
            code = code.substring(0, start) + " " + code.substring(end);
        }

        if (!code.startsWith("<") || !code.endsWith(">")) {
            return false;
        }

        for (int i = 0; i < code.length(); i++) {
            char ch = code.charAt(i);
            if (ch == '<') {
                int temp = i;
                StringBuilder sb = new StringBuilder();
                while (temp < code.length() && code.charAt(temp) != '>') {
                    sb.append(code.charAt(temp));
                    temp++;
                }
                sb.append(">");
                if (sb.toString().startsWith("</")) {
                    // 闭标签比开标签多
                    if (stack.isEmpty()) {
                        return false;
                    }
                    String pop = stack.pop();
                    // 闭标签名和开标签名不同
                    if (!sb.deleteCharAt(1).toString().equals(pop)) {
                        return false;
                    }
                    // 有多个根标签
                    if (stack.isEmpty() && temp != code.length() - 1) {
                        return false;
                    }
                    // 校验闭标签名是否合法
                    // '/'已经在第58行被删除
                    if (invalidTag(sb.toString())) {
                        return false;
                    }
                } else {
                    // 校验开标签名是否合法
                    if (invalidTag(sb.toString())) {
                        return false;
                    }
                    // 将开标签名加到栈里面
                    stack.push(sb.toString());
                }
                i = temp;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 校验标签名是否合法
     * <p>标签名只能包含大写字母</p>
     *
     * @param string 标签名
     * @return true: 不合法 | false: 合法
     */
    public static boolean invalidTag(String string) {
        string = string.substring(1, string.length() - 1);
        if (string.length() < 1 || string.length() > 9) {
            return true;
        }
        String regex = "[^A-Z]";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(string);
        return matcher.find();
    }
}
