package array;

/**
 * 寻找旋转排序数组中的最小值
 * https://leetcode-cn.com/leetbook/read/array-and-string/c3ki5/
 *
 * @author liuhj
 * @date 2021/12/11 15:40
 */
public class FindMinValueInRotationRankingArray {

    public static int findMin(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i]>nums[i+1]){
                return nums[i+1];
            }
        }
        return nums[0];
    }
}
