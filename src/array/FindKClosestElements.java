package array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 找到 K 个最接近的元素
 * https://leetcode-cn.com/problems/find-k-closest-elements/
 *
 * @author liuhjhj
 * @date 2022/3/23
 **/
public class FindKClosestElements {

    /**
     * 二分查找, 寻找最优左边界
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0;
        int end = arr.length - k;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return Arrays.stream(Arrays.copyOfRange(arr, start, start + k)).boxed().collect(Collectors.toList());
    }

    /**
     * 滑动窗口
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public static List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> integers = Arrays.stream(arr).boxed().collect(Collectors.toList());
        if (x <= integers.get(0)) {
            return integers.stream().limit(k).collect(Collectors.toList());
        } else if (x >= integers.get(integers.size() - 1)) {
            return integers.stream().skip(integers.size() - k).collect(Collectors.toList());
        }
        int start = 0;
        while (start + k < integers.size() && x - integers.get(start) > integers.get(start + k) - x) {
            start++;
        }
        return integers.stream().skip(start).limit(k).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // List<Integer> closestElements = findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9);
        List<Integer> closestElements = findClosestElements2(new int[]{1, 1, 2, 3, 3, 3, 4, 6, 8, 8}, 6, 8);
        // List<Integer> closestElements = findClosestElements2(new int[]{0,0,1,2,3,3,4,7,7,8}, 3, 5);
        System.out.println(closestElements);
    }
}
