package array;

import java.util.Arrays;

/**
 * 零矩阵
 * https://leetcode-cn.com/leetbook/read/array-and-string/ciekh/
 *
 * @author liuhj
 * @date 2021年12月4日10:01:52
 */
public class ZeroMatrix {

    public static void setZeroes(int[][] matrix) {
        boolean rowZero = false;
        boolean columnZero = false;
        // 遍历第0行, 看第0行是否有0
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                rowZero = true;
                break;
            }
        }
        // 遍历第0列, 看第0列是否有0
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                columnZero = true;
                break;
            }
        }
        // 从第1行开始遍历, 如果有0, 把第0行和第0列相应位置的数字置0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 从第1行开始遍历, 如果第0行或第0列相应位置的数字为0, 则把当前遍历的数字置0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 如果第0行有0, 把整个第0行置为0
        if (rowZero) {
            Arrays.fill(matrix[0], 0);
        }
        // 如果第0列有0, 把整个第0列置为0
        if (columnZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        /// int[][] nums = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] nums = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        /// int[][] nums = {{0,1}};
        setZeroes(nums);
        System.out.println(Arrays.deepToString(nums));
    }
}
