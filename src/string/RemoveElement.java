package string;

/**
 * 移除元素
 * https://leetcode-cn.com/leetbook/read/array-and-string/cwuyj/
 *
 * @author liuhj
 * @date 2021/12/10 21:20
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[slow] = nums[i];
            if (nums[i] != val){
                slow++;
            }
        }
        return slow;
    }
}
