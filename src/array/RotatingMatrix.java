package array;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/rotate-matrix-lcci/">旋转矩阵</a>
 *
 * @author liuhj
 * @date 2021年12月3日21:57:22
 */
public class RotatingMatrix {

    /**
     * 先沿着对角线交换每个数字的位置
     * 再第n行与倒数第n行交换位置即可
     *
     * @param matrix 待旋转的数组
     */
    public static void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length == 1) {
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - j - 1][matrix.length - i - 1];
                matrix[matrix.length - j - 1][matrix.length - i - 1] = temp;
            }
        }
        for (int i = 0; i < matrix.length / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[matrix.length - i - 1];
            matrix[matrix.length - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //int[][] nums = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        rotate(nums);
        Arrays.stream(nums).forEach(num -> System.out.println(Arrays.toString(num)));
    }

}
