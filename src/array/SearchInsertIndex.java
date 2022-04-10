package array;

/**
 * 搜索插入位置
 * https://leetcode-cn.com/leetbook/read/array-and-string/cxqdh/
 * 知识点: 二分查找
 *
 * @author liuhj
 * @date 2021年11月28日15:38:52
 */
public class SearchInsertIndex {

    public static int searchInsert(int[] nums, int target) {
        return find(nums,0,nums.length -1,target);
    }

    /**
     * 二分查找
     * @param nums 待查找的数组
     * @param left 数组开始索引
     * @param right 数组结束索引
     * @param target 待查找的数字
     * @return 待查找的数字所在的下标或将其插入后所在的下标
     */
    public static int find(int[] nums,int left,int right,int target){
        if(left >= right){
            if(nums[right]>=target){
                return right;
            }else{
                return right+1;
            }
        }
        int centerIndex = (left + right) / 2 + 1;
        if(nums[centerIndex] == target){
            return centerIndex;
        }else if(nums[centerIndex]<target){
            left = centerIndex +1;
            return find(nums,left,right,target);
        }else{
            right = centerIndex -1;
            return find(nums,left,right,target);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        int result = searchInsert(nums, target);
        System.out.println(result);
    }
}
