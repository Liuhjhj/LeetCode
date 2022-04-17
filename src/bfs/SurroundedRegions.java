package bfs;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/surrounded-regions/">被围绕的区域</a>
 *
 * @author liuhj
 * @date 2021/12/19 16:06
 */
public class SurroundedRegions {

    public static final char O = 'O';
    public static final char X = 'X';
    public static final char L = 'L';

    public static void solve(char[][] board) {
        // 先把没有被围绕的小岛变成 L
        // 遍历第0行
        // 遍历最后一行
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == O) {
                bfs(board, 0, j, false);
            }
            if (board[board.length-1][j] == O) {
                bfs(board, board.length-1, j, false);
            }
        }
        // 遍历第0列
        // 遍历最后一列
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == O){
                bfs(board, i, 0, false);
            }
            if (board[i][board[0].length-1] == O){
                bfs(board, i, board[0].length-1, false);
            }
        }
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                if (board[i][j] == O){
                    board[i][j] = X;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == L) {
                    board[i][j] = O;
                }
            }
        }
    }

    public static void bfs(char[][] board, int row, int column, boolean isSurround) {
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length || board[row][column] != O) {
            return;
        }
        if (isSurround) {
            board[row][column] = X;
        } else {
            board[row][column] = L;
        }
        bfs(board, row - 1, column, isSurround);
        bfs(board, row + 1, column, isSurround);
        bfs(board, row, column - 1, isSurround);
        bfs(board, row, column + 1, isSurround);
    }

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','O','X'}};
        solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}
