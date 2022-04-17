package bfs;

/**
 * <a href="https://leetcode-cn.com/problems/number-of-islands/">岛屿的个数</a>
 * <p>知识点: 深/广度优先遍历</p>
 *
 * @author liuhj
 * @date 2021/12/11 21:36
 */
public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    result++;
                    bfs(grid,i,j);
                }
            }
        }
        return result;
    }

    public static void bfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        bfs(grid, i - 1, j);
        bfs(grid, i + 1, j);
        bfs(grid, i, j - 1);
        bfs(grid, i, j + 1);
    }
}
