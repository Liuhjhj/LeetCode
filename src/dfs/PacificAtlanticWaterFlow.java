package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/pacific-atlantic-water-flow/">太平洋大西洋水流问题</a>
 *
 * @author liuhjhj
 * @date 2022/4/27
 **/
public class PacificAtlanticWaterFlow {

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] toPacific = new boolean[heights.length][heights[0].length];
        boolean[][] toAtlantic = new boolean[heights.length][heights[0].length];
        List<List<Integer>> result = new ArrayList<>(heights.length * heights[0].length);
        for (int i = 0; i < heights.length; i++) {
            dfs(heights, i, 0, toPacific);
            dfs(heights, i, heights[0].length - 1, toAtlantic);
        }
        for (int i = 0; i < heights[0].length; i++) {
            dfs(heights, 0, i, toPacific);
            dfs(heights, heights.length - 1, i, toAtlantic);
        }
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (toPacific[i][j] && toAtlantic[i][j]) {
                    List<Integer> list = new ArrayList<>(2);
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
            }
        }
        return result;
    }

    public static void dfs(int[][] height, int i, int j, boolean[][] ocean) {
        if (ocean[i][j]) {
            return;
        }
        ocean[i][j] = true;
        if (i - 1 >= 0 && i - 1 < height.length && j < height[0].length && height[i][j] <= height[i - 1][j]) {
            dfs(height, i - 1, j, ocean);
        }
        if (i + 1 < height.length && j < height[0].length && height[i][j] <= height[i + 1][j]) {
            dfs(height, i + 1, j, ocean);
        }
        if (i < height.length && j - 1 >= 0 && j - 1 < height[0].length && height[i][j] <= height[i][j - 1]) {
            dfs(height, i, j - 1, ocean);
        }
        if (i < height.length && j + 1 < height[0].length && height[i][j] <= height[i][j + 1]) {
            dfs(height, i, j + 1, ocean);
        }
    }

    public static void main(String[] args) {
        /// int[][] height = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        /// int[][] height = {{1,2},{2,1}};
        /// int[][] height = {{2, 1}, {1, 2}};
        /// int[][] height = {{1}, {1}};
        int[][] height = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        List<List<Integer>> lists = pacificAtlantic(height);
        System.out.println(lists);
    }
}
