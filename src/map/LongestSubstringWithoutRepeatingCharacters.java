package map;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 知识点: 滑动窗口
 *
 * @author liuhjhj
 * @date 2022/3/5
 **/
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }
        Set<Character> seen = new HashSet<>();
        int head = 0;
        int end = 0;
        int result = 0;
        while (end<s.length()) {
            if (head == end){
                seen.add(s.charAt(head));
                end++;
            }else {
                if (seen.contains(s.charAt(end))){
                    result = Math.max(result,seen.size());
                    seen.remove(s.charAt(head));
                    head++;
                }else{
                    seen.add(s.charAt(end));
                    end++;
                }
            }
        }
        if (!seen.isEmpty()){
            result = Math.max(result, seen.size());
        }
        return result;
    }

    public static void main(String[] args) {
        int result = lengthOfLongestSubstring("dvdf");
        System.out.println(result);
    }
}
