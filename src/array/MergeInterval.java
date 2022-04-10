package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 * https://leetcode-cn.com/leetbook/read/array-and-string/c5tv3/
 *
 * @author liuhj
 * @date 2021年12月1日20:56:26
 */
public class MergeInterval {

    public static int[][] merge(int[][] intervals) {
        // 按左区间进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> result = new ArrayList<>(10);
        int resultEndIndex = 0;
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            // 遍历的当前区间是result末尾的区间的子集, 直接合并
            if (intervals[i][0] <= result.get(resultEndIndex)[1]) {
                if (intervals[i][1]>result.get(resultEndIndex)[1]) {
                    result.get(resultEndIndex)[1] = intervals[i][1];
                }
            }else {
                // 不是子集, 把遍历的当前区间添加到result的末尾
                result.add(intervals[i]);
                resultEndIndex++;
            }
        }
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        /// int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
        /// int[][] nums = {{1,4},{4,5}};
        /// int[][] nums = {{1,4},{5,5}};
        /// int[][] nums = {{1,4},{0,0}};
        int[][] nums = {{1,4},{2,3}};
        int[][] result = merge(nums);
        Arrays.stream(result).forEach(num -> Arrays.stream(num).forEach(System.out::println));
    }
}
