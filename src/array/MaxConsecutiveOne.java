package array;

/**
 * 最大连续一
 * https://leetcode-cn.com/leetbook/read/array-and-string/cd71t/
 *
 * @author liuhj
 * @date 2021/12/10 21:30
 */
public class MaxConsecutiveOne {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int fast = 0;
        int slow = -1;
        int maxOneLength = 0;
        for (; fast < nums.length; fast++) {
            if (nums[fast] == 1) {
                if (slow == -1) {
                    slow = fast;
                }
            } else {
                if (slow != -1) {
                    maxOneLength = Math.max(maxOneLength, fast - slow);
                    slow = -1;
                }
            }
        }
        if (slow != -1){
            maxOneLength = Math.max(maxOneLength, fast - slow);
        }
        return maxOneLength;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        int consecutiveOnes = findMaxConsecutiveOnes(nums);
        System.out.println(consecutiveOnes);
    }
}
