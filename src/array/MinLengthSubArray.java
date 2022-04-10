package array;

/**
 * 长度最小的子数组
 * https://leetcode-cn.com/leetbook/read/array-and-string/c0w4r/
 * 知识点: 前缀和+二分查找 || 滑动窗口
 * 我使用的是滑动窗口解法 O(n)时间复杂度
 *
 * @author liuhj
 * @date 2021/12/10 21:46
 */
public class MinLengthSubArray {

    public static int minSubArrayLen(int target, int[] nums) {
        // 快指针
        int fast = 0;
        // 慢指针
        int slow = 0;
        // 总和
        int sum = 0;
        // 当sum >= target时的长度
        int sumLength = 0;
        // sum >= target时的最小长度
        int resultLength = 0;
        // 用于标记上一次循环时slow的值, 防止死循环
        int preSlow = -1;
        while (slow <= fast) {
            if (sum < target) {
                sum += nums[fast];
                // 出现了死循环
                if (preSlow == slow && nums[fast] == 0) {
                    break;
                }
                // 标记当前slow的值
                preSlow = slow;
                // nums[fast]只能被加一次
                if (fast == nums.length - 1) {
                    nums[fast] = 0;
                }
                // 当fast为nums.length-1时, 不再前进
                // 只有slow前进
                // 如果fast为nums.length-1, 且slow不前进时, 就造成了死循环
                if (fast != nums.length - 1) {
                    fast++;
                }
                // sum < target时长度加1
                sumLength++;
            } else {
                if (resultLength == 0) {
                    resultLength = sumLength;
                } else {
                    resultLength = Math.min(resultLength, sumLength);
                }
                // slow前进一位, sum需要减掉slow的值
                sum -= nums[slow];
                // sum减掉slow的值后长度减1
                sumLength--;
                slow++;
                // slow前进了一位, 在下一次循环时重新标记
                preSlow = -1;
            }
        }
        return resultLength;
    }

    public static void main(String[] args) {
        /// int[] nums = {1,2,3,4,5};
        /// int[] nums = {1,1,1,1,1,1,1};
        /// int target = 11;
        /// int[] nums = {1,4,4};
        /// int target = 4;
        int[] nums = {1, 1, 1, 1, 7};
        int target = 7;
        int minSubArrayLen = minSubArrayLen(target, nums);
        System.out.println(minSubArrayLen);
    }
}
