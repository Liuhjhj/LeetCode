package dfs;

/**
 * <a href="https://leetcode.cn/problems/word-search/">单词搜索</a>
 *
 * @author liuhjhj
 * @date 2022/6/21 22:02
 **/
public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean exist = exist(board, word);
        System.out.println(exist);
    }

    public static boolean exist(char[][] board, String word) {
        boolean[][] seen = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(seen, board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(boolean[][] seen, char[][] board, int x, int y, int index, String word) {
        if (index == word.length() - 1) {
            return board[x][y] == word.charAt(index);
        }
        if (board[x][y] != word.charAt(index)) {
            return false;
        }
        seen[x][y] = true;
        boolean bool = false;
        int[][] iterates = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] iterate : iterates) {
            int newX = x + iterate[0];
            int newY = y + iterate[1];
            if (notOutOfIndex(board, newX, newY) && !seen[newX][newY]) {
                bool = dfs(seen, board, newX, newY, index + 1, word);
                if (bool) {
                    break;
                }
            }
        }
        seen[x][y] = false;
        return bool;
    }

    public static boolean notOutOfIndex(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
}
