package array;

/**
 * 删除排序数组中的重复项
 * https://leetcode-cn.com/leetbook/read/array-and-string/cq376/
 * 知识点: 快慢指针法
 *
 * @author liuhj
 * @date 2021/12/11 15:48
 */
public class DeleteRepeatNum {

    public static int removeDuplicates(int[] nums) {
        if (nums.length <=1){
            return nums.length;
        }
        int fast = 1;
        int slow = 1;
        for (;fast<nums.length;fast++){
            nums[slow] = nums[fast];
            if (nums[slow] != nums[slow-1]){
                slow++;
            }
        }
        return slow;
    }
}
