package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/diagonal-traverse/">对角线遍历</a>
 * <p>知识点: 复杂问题简单化</p>
 *
 * @author liuhj
 * @date 2021年12月4日11:18:34
 */
public class DiagonalTraversal {
    /**
     * 先把沿着一个方向遍历所有对角线(例如从上往下)
     * 再把偶数列的数组进行翻转
     *
     * @param mat 待遍历的数组
     * @return 沿着对角线遍历的顺序
     */
    public static int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 1) {
            return mat[0];
        } else if (mat[0].length == 1) {
            List<Integer> result = new ArrayList<>(mat.length);
            Arrays.stream(mat).forEach(nums -> result.add(nums[0]));
            return result.stream().mapToInt(num -> num).toArray();
        }
        int rowLength = mat[0].length;
        int colLength = mat.length;
        List<List<Integer>> result = new ArrayList<>(10);
        // 横向遍历第0行
        for (int i = 0; i < rowLength; i++) {
            int curRowIndex = 0;
            int curColIndex = i;
            List<Integer> temp = new ArrayList<>(10);
            for (; curRowIndex < colLength && curColIndex >= 0; curRowIndex++, curColIndex--) {
                temp.add(mat[curRowIndex][curColIndex]);
            }
            result.add(temp);
        }
        // 纵向遍历最后一列
        for (int i = 1; i < colLength; i++) {
            int curRowIndex = i;
            int curColIndex = mat[0].length - 1;
            List<Integer> temp = new ArrayList<>(10);
            for (; curRowIndex < colLength && curColIndex >= 0; curRowIndex++, curColIndex--) {
                temp.add(mat[curRowIndex][curColIndex]);
            }
            result.add(temp);
        }
        List<Integer> resultList = new ArrayList<>(10);
        // 翻转偶数列的数组
        for (int i = 0; i < result.size(); i++) {
            if (i % 2 == 0) {
                Collections.reverse(result.get(i));
            }
            // 二维遍历序列转换为一维遍历序列
            resultList.addAll(result.get(i));
        }
        return resultList.stream().mapToInt(num -> num).toArray();
    }

    public static void main(String[] args) {
        /// int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        /// int[][] nums = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        /// int[][] nums = {{1, 2, 3, 4}};
        /// int[][] nums = {{1},{2}};
        /// int[][] nums = {{1,2},{3,4},{5,6}};
        int[][] nums = {{1, 2, 3}, {4, 5, 6}};
        int[] result = findDiagonalOrder(nums);
        System.out.println(Arrays.toString(result));
    }
}
