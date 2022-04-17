package array;

/**
 * <a href="https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/">寻找旋转排序数组中的最小值</a>
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
