package array;

/**
 * <a href="https://leetcode-cn.com/problems/search-a-2d-matrix-ii/">搜索二维矩阵 II</a>
 *
 * @author liuhjhj
 * @date 2022/5/1
 **/
public class SearchA2dMatrixPartTwo {

    /**
     * 因为二维数组的行和列都是按升序排列
     * <p>因此从二维数组的右上角matrix[0][matrix[0].length - 1]开始搜索</p>
     * <p>如果比目标值小, 则将行的下标加一, 即把0加一</p>
     * <p>如果比目标值大, 则将列的下标减一, 即把matrix[0].length - 1减一</p>
     *
     * @param matrix 二维数组
     * @param target 目标值
     * @return 二维数组中有目标值: true, 否则: false
     */
    public boolean findNumberIn2dArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (col >= 0 && row < matrix.length) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
