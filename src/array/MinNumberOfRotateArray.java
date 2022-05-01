package array;

/**
 * <a href="https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/">旋转数组的最小数字</a>
 * <p>知识点: 二分查找</p>
 *
 * @author liuhjhj
 * @date 2022/5/1
 **/
public class MinNumberOfRotateArray {

    public int minArray(int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] < numbers[end]) {
                return numbers[start];
            } else {
                int center = start + (end - start) / 2;
                if (numbers[center] > numbers[end]) {
                    start = center + 1;
                } else if (numbers[center] < numbers[end]) {
                    end = center;
                } else {
                    start++;
                    end--;
                }
            }
        }
        return numbers[start];
    }
}
