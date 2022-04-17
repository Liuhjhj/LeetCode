package array;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/move-zeroes/">移动零</a>
 * <p>知识点: 快慢指针法</p>
 *
 * @author liuhj
 * @date 2021/12/11 15:55
 */
public class MoveZero {

    public static void moveZeroes(int[] nums) {
        if (nums.length <=1){
            return;
        }
        int fast = 0;
        int slow = 0;
        for (;fast<nums.length;fast++){
            nums[slow] = nums[fast];
            if (nums[slow] != 0){
                slow++;
            }
        }
        for (;slow<nums.length;slow++){
            nums[slow] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,2,4,0,0,3,0,5,1,0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
