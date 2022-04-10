package array;

import java.util.Arrays;

/**
 * 数组拆分-I
 * https://leetcode-cn.com/leetbook/read/array-and-string/c24he/
 *
 * @author liuhj
 * @date 2021/12/8 21:51
 */
public class ArraySplit {

    public static int arrayPairSum(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum+=nums[i];
        }
        return sum;
    }
}
