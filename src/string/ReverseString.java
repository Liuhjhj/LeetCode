package string;

/**
 * <a href="https://leetcode-cn.com/problems/reverse-string/">翻转字符串</a>
 *
 * @author liuhj
 * @date 2021/12/8 21:42
 */
public class ReverseString {

    public static void reverseString(char[] s) {
        int head = 0;
        int end = s.length-1;

        for (;head<s.length-1&&head<end;head++,end--){
            char temp = s[head];
            s[head] = s[end];
            s[end] = temp;
        }
    }
}
