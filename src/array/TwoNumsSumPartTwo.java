package array;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/">两数之和-II: 输入有序数组</a>
 * <p>知识点: 二分查找</p>
 *
 * @author liuhj
 * @date 2021/12/8 22:01
 */
public class TwoNumsSumPartTwo {

    /**
     * 从升序数组中找出和为target的两个数字的下标
     *
     * @param numbers 升序数组
     * @param target  目标和
     * @return 两个数字的下标
     */
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 2) {
            return new int[]{1, 2};
        }
        int[] result = new int[2];
        int i = 0;
        // 找出target的一半的下标
        // 以target的一半为基准, 将整个数组分为左右两个部分
        while (numbers[i] < target / 2) {
            i++;
        }
        int left = i + 1;
        int right = numbers.length - 1 - i;
        // 使用二分查找
        // 左边的数字比右边少, 左边遍历, 对右边使用二分查找
        if (left <= right) {
            for (int j = 0; j <= i; j++) {
                // 无论是对哪边使用二分查找, i都作为边界, 否则会出现找不到和的情况
                // 例如{1,2,4,4} target=8或{2,7,11,15} target=9
                int find = binarySearch(numbers, i, numbers.length - 1, target - numbers[j]);
                if (find != -1) {
                    result[0] = j + 1;
                    result[1] = find + 1;
                    break;
                }
            }
        }
        // 左边的数字比右边多, 对左边使用二分查找
        if (left > right) {
            int j = numbers.length - 1;
            for (; j >= i; j--) {
                if (numbers[j] > target) {
                    continue;
                }
                // 无论是对哪边使用二分查找, i都作为边界, 否则会出现找不到和的情况
                int find = binarySearch(numbers, 0, i, target - numbers[j]);
                if (find != -1) {
                    result[1] = j + 1;
                    result[0] = find + 1;
                    break;
                }
            }
        }
        // 如果两个下标值相同, 说明两个下标值所在的数字相等, 需要把result[1]加1
        if (result[0] == result[1]) {
            result[1]++;
        }
        return result;
    }

    /**
     * 二分查找
     *
     * @param numbers 待查找数组
     * @param start   左边界
     * @param end     右边界
     * @param target  目标值
     * @return 目标值所在数字的下标, 未找到则返回-1
     */
    public static int binarySearch(int[] numbers, int start, int end, int target) {
        if (start == end) {
            if (numbers[start] == target) {
                return start;
            } else {
                return -1;
            }
        } else if (start > end) {
            return -1;
        }
        int center = (start + end) / 2;
        if (numbers[center] == target) {
            return center;
        } else if (numbers[center] < target) {
            return binarySearch(numbers, center + 1, end, target);
        } else if (numbers[center] > target) {
            return binarySearch(numbers, start, center - 1, target);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum(numbers, target);
        System.out.println(Arrays.toString(ints));
    }
}
