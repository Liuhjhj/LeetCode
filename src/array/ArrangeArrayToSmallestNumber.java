package array;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/">把数组排成最小的数</a>
 *
 * @author liuhjhj
 * @date 2022/7/10 下午11:24
 */
public class ArrangeArrayToSmallestNumber {

    /**
     * <p>1. 把数组中的数字转换成字符串进行排序</p>
     * <p>2. 排序方法是: 将两个数字记为strA, strB</p>
     * <p>3. 比较strA + strB和strB + strA的大小</p>
     * <p>4. strA + strB小说明strA比strB小</p>
     * <p>5. 数字A应该排在数字B的前面</p>
     *
     * @param nums 输入的数组
     * @return 数组排成的最小的数字
     */
    public static String minNumber(int[] nums) {
        nums = Arrays.stream(nums)
                .boxed()
                .map(String::valueOf)
                .sorted((a, b) -> (a + b).compareTo(b + a))
                .map(Integer::valueOf)
                .mapToInt(Integer::intValue)
                .toArray();
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }
}
