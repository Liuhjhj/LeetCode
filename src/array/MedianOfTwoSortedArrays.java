package array;

/**
 * <a href="https://leetcode-cn.com/problems/median-of-two-sorted-arrays/">寻找两个正序数组的中位数</a>
 *
 * @author liuhjhj
 * @date 2022/3/27
 **/
public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if (totalLength % 2 == 1) {
            return getKNumber(nums1, nums2, totalLength / 2 + 1);
        } else {
            int firstKNumber = getKNumber(nums1, nums2, totalLength / 2);
            int secondKNumber = getKNumber(nums1, nums2, totalLength / 2 + 1);
            return (double) (firstKNumber + secondKNumber) / 2;
        }
    }

    /**
     * 找两个升序排列数组中第k小的数
     * <p></p>
     * 1. 先找出数组1中第k/2个数: nums1[k/2-1]和数组2中第k/2个数nums2[k/2-1]
     * <p></p>
     * 2. nums1[k/2-1]和nums2[k/2-1]作比较
     * <p></p>
     * 3. 若nums1[k/2-1] < nums2[k/2-1], 则数组1中下标从0到k/2-1一共k/2个数中不可能有第k小的数;
     * 反之亦然
     * <p></p>
     * 4. 那么可以把数组1中下标从0到k/2-1共k/2个数从数组1中删除
     * <p></p>
     * 5. 那么就题目就从nums1.length + nums2.length个数字当中寻找第k小的数变成了
     * 从nums1.length + nums2.length - k/2中寻找第k/2小的数 (从数组1中删除了前k/2个数字, k=k-k/2)
     * 6. 重复1到5步
     * <p></p>
     * 7. 直到k = 1或某个数组里面的数字被删完了
     * <p></p>
     * 8. 如果k = 1, 说明只要从数组1和数组2中剩下的所有数字里面找最小的数, 因为两个数组数字都是升序排列
     * 所以只需要比较nums1[0]和nums2[0]
     * <p></p>
     * 9. 如果nums1中的数字被删完了, 此时k>1, 那么此时只需要从数组2中找第 k (k在一直变小) 小的数, 反之亦然
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @param k     第k小
     * @return 第k小的数
     */
    public static int getKNumber(int[] nums1, int[] nums2, int k) {
        // nums1的删除下标偏移量, 表示删除小于该偏移量的下标的数字
        // 偏移量指向数组的第一个数字
        // 如果firstOffsetIndex = 2, 则表示删除nums[0]和nums[1]
        int firstOffsetIndex = 0;
        // nums2的下标偏移量
        int secondOffsetIndex = 0;

        while (k != 1 && firstOffsetIndex < nums1.length && secondOffsetIndex < nums2.length) {

            // 数组中第k/2个数字的下标为k/2-1
            // 如果越界, 则指向数组的最后一个数字
            int firstIndex = Math.min(firstOffsetIndex + k / 2, nums1.length) - 1;
            int secondIndex = Math.min(secondOffsetIndex + k / 2, nums2.length) - 1;
            if (nums1[firstIndex] <= nums2[secondIndex]) {
                // 删除下标从0到k/2-1个数字, k应该减去k/2
                k -= firstIndex - firstOffsetIndex + 1;
                // 删除下标从0到firstIndex的数字, 因此firstOffsetIndex应该为firstIndex+1
                firstOffsetIndex = firstIndex + 1;
            } else {
                k -= secondIndex - secondOffsetIndex + 1;
                secondOffsetIndex = secondIndex + 1;
            }
        }
        // 数组1被删完了, 从数组2中找出第k小的数, 第k小的数下标为nums2[k-1]
        if (firstOffsetIndex >= nums1.length) {
            return nums2[secondOffsetIndex + k - 1];
        } else if (secondOffsetIndex >= nums2.length) {
            return nums1[firstOffsetIndex + k - 1];
        } else {
            // 两个数组的数字都没有被删完, 那么此时k=1, 只要找出两个数组中最小的那个数即可
            // 由于两个数组都是升序排列, 所以只需比较两个数组中的第一个数
            return Math.min(nums1[firstOffsetIndex], nums2[secondOffsetIndex]);
        }
    }

    public static void main(String[] args) {
        //int[] nums1 = {1, 3, 4, 9};
        //int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //int[] nums1 = {1, 3};
        //int[] nums2 = {2};
        //int[] nums1 = {1, 3};
        //int[] nums2 = {2,4};
        int[] nums1 = {0, 0, 0, 0, 0};
        int[] nums2 = {-1, 0, 0, 0, 0, 0, 1};
        //int[] nums1 = {4};
        //int[] nums2 = {1, 2, 3};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
