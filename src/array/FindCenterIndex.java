package array;

/**
 * <a href="https://leetcode-cn.com/problems/find-pivot-index/">寻找数组的中心索引</a>
 *
 * @author liuhj
 * @date 2021年11月28日15:38:52
 */
public class FindCenterIndex {

    public static int pivotIndex(int[] nums) {
        // rightSum = total - leftSum - nums[i]
        // rightSum = leftSum
        // total - leftSum - nums[i] = leftSum
        // 2 * leftSum = total - nums[i]
        int total = 0;
        int[] leftSum = new int[nums.length];
        int j = 1;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            if (i != 0) {
                leftSum[i] = leftSum[i-1] + nums[i-1];
            }
        }
        for (int i = 0; i < leftSum.length; i++) {
            if (leftSum[i] * 2 == total - nums[i]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        int i = pivotIndex(nums);
        System.out.println(i);
    }
}
