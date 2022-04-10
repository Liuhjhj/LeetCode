package array;

import java.util.Arrays;

/**
 * 找出第 k 小的距离对
 * https://leetcode-cn.com/problems/find-k-th-smallest-pair-distance/
 *
 * @author liuhjhj
 * @date 2022/3/30
 **/
public class FindKthSmallestPairDistance {

    /**
     * 找出第K小的距离对
     * @param nums
     * @param k
     * @return
     */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums[nums.length - 1] - nums[0];
        while (start < end) {
            int mid = start + (end - start) / 2;
            int left = 0, count = 0;
            for (int right = 0; right < nums.length; right++) {
                while (nums[right] - nums[left] > mid) {
                    left++;
                }
                count += right - left;
            }
            if (count >= k) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
