package string;

/**
 * <a href="https://leetcode-cn.com/leetbook/read/array-and-string/ceda1/">最长公共前缀</a>
 *
 * @author liuhj
 * @date 2021年12月4日18:50:10
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1){
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < strs.length; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < strs[i].length() && j < strs[i - 1].length(); j++) {
                if (strs[i].charAt(j) == strs[i - 1].charAt(j)) {
                    sb.append(strs[i].charAt(j));
                }else{
                    break;
                }
            }
            strs[i] = sb.toString();
            if ("".equals(sb.toString())){
                return "";
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"addddd","123456","12456"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }
}
