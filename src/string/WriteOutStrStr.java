package string;

/**
 * <a href="https://leetcode-cn.com/problems/implement-strstr/">实现strStr()方法</a>
 * <p>知识点: KMP算法</p>
 *
 * @author liuhj
 * @date 2021/12/5 17:40
 */
public class WriteOutStrStr {

    /**
     * 1. 构建next数组, next[i]等于从0到i的最长公共前后缀的长度, next[0] = 0
     * 2. 进行字符串匹配, 如果在模式串下标为j (j>0) 的字符匹配失败, 则模式串退回到next[j-1]的位置
     * 3. 如果j == 0, 则主串的下标i加1
     * 4. 当j等于模式串的长度时, 表示匹配成功, i-j即为模式串在主串开始的下标
     * 5. 时间复杂度O(m+n), 只回退模式串的下标, 不回退主串的下标
     *
     * @param haystack 主串: 待匹配的长字符串
     * @param needle   模式串: 需匹配的短字符串
     * @return 模式串在主串开始下标, 匹配失败返回-1
     */
    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        if (haystack.length() == 0 || needle.length() == 0) {
            return 0;
        }
        int[] next = constructNext(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); ) {
            while (j < needle.length() && i < haystack.length()) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                } else if (j > 0) {
                    j = next[j - 1];
                } else {
                    i++;
                }
                if (j == needle.length()) {
                    return i - j;
                }
            }
        }
        return -1;
    }

    /**
     * 构建next数组
     *
     * @param modeString 模式串
     * @return 模式串的next数组
     */
    public static int[] constructNext(String modeString) {
        int[] next = new int[modeString.length()];
        next[0] = 0;
        int i = 1;
        int j = 0;
        while (i < modeString.length()) {
            while (j > 0 && modeString.charAt(i) != modeString.charAt(j)) {
                j = next[j - 1];
            }
            if (modeString.charAt(i) == modeString.charAt(j)) {
                next[i] = j + 1;
                i++;
                j++;
            } else if (j == 0) {
                i++;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String mainString = "aabaaabaab";
        String modeString = "aabaab";
//        String mainString = "mississippi";
//        String modeString = "issip";
        int i = strStr(mainString, modeString);
        System.out.println(i);
    }
}
