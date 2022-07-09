package array;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/next-greater-element-iii/">下一个更大元素 III</a>
 *
 * @author liuhjhj
 * @date 2022/7/9 下午11:53
 */
public class NextGreaterElementPartThree {

    /**
     * <p>获取比n大的最小数字</p>
     * <p>1. 倒序遍历, 找到第一个不是升序排列的数字, 记为small</p>
     * <p>2. 再次倒序遍历, 找到第一个比small大的数字, 记为big</p>
     * <p>3. 交换big和small的位置</p>
     * <p>4. 将big后面的数字(不包括big)按照升序进行排序</p>
     * <p>5. 即得到比n大的数字中的最小的那个数字</p>
     *
     * @param n 目标数字
     * @return 比n大的数字中的最小数字
     */
    public int nextGreaterElement(int n) {
        int bigIndex = -1;
        int smallIndex = -1;
        char small = '0';

        char[] chars = String.valueOf(n).toCharArray();
        for (int i = chars.length - 1; i >= 1; i--) {
            if (chars[i - 1] < chars[i]) {
                small = chars[i - 1];
                smallIndex = i - 1;
                break;
            }
        }
        if (smallIndex < 0) {
            return -1;
        }
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] > small) {
                bigIndex = i;
                break;
            }
        }
        char temp = chars[bigIndex];
        chars[bigIndex] = chars[smallIndex];
        chars[smallIndex] = temp;
        Arrays.sort(chars, smallIndex + 1, chars.length);
        long result = Long.parseLong(new String(chars));
        if (result > Integer.MAX_VALUE) {
            return -1;
        } else {
            return (int) result;
        }
    }
}
