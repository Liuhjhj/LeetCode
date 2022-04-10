package string;

/**
 * 外观数列
 * https://leetcode-cn.com/problems/count-and-say/
 *
 * @author liuhjhj
 * @date 2022/4/10
 **/
public class CountAndSay {

    public static String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            String s = sb.toString();
            sb.setLength(0);
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                int count = 1;
                for (int k = j + 1; k < s.length() && s.charAt(k) == s.charAt(j); k++){
                    count++;
                    j++;
                }
                sb.append(count).append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        for (int i = 1; i < 31; i++) {
            String s = countAndSay(i);
            System.out.println(s);
        }
    }
}
