package array;

import java.util.Arrays;

/**
 * 移动零
 * https://leetcode-cn.com/leetbook/read/array-and-string/c6u02/
 * 知识点: 快慢指针法
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
