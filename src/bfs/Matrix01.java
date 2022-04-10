package bfs;

import java.util.*;

/**
 * 0-1矩阵
 * https://leetcode-cn.com/problems/01-matrix/
 *
 * @author liuhj
 * @date 2022/1/16 16:29
 */
public class Matrix01 {

    public static final int MAX = 1001;

    public static int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] = -1;
                } else {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + direction[i][0];
                int newY = y + direction[i][1];
                if (newX >= 0 && newX < mat.length && newY >= 0 && newY < mat[0].length && mat[newX][newY] == -1) {
                    mat[newX][newY] = mat[x][y] + 1;
                    queue.offer(new int[]{newX,newY});
                }
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        /// int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        /// int[][] mat = {{0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 1, 1}, {1, 0, 0, 0, 1}};
        int[][] mat = {{1, 1, 0, 0, 1, 0, 0, 1, 1, 0}, {1, 0, 0, 1, 0, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 0, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 0, 0, 1}, {1, 1, 1, 1, 1, 0, 0, 1, 1, 1}, {0, 1, 0, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 0, 1, 1, 1, 1}};
        int[][] ints = updateMatrix(mat);
        System.out.println(Arrays.deepToString(ints));
    }
}
