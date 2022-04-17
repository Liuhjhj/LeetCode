package map;

import java.util.*;

/**
 * <a href="https://leetcode-cn.com/problems/valid-sudoku/">有效数独</a>
 *
 * @author liuhjhj
 * @date 2022/3/4
 **/
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        List<List<Set<Character>>> sudokuSetList = new ArrayList<>(9);

        List<Set<Character>> rowSetList = new ArrayList<>(9);

        List<Set<Character>> colSetList = new ArrayList<>(9);
        for (int i = 0; i < 3; i++) {
            sudokuSetList.add(new ArrayList<>(9));
            for (int j = 0; j < 3; j++) {
                sudokuSetList.get(i).add(new HashSet<>(16));
                rowSetList.add(new HashSet<>(16));
                colSetList.add(new HashSet<>(16));
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.'){
                    continue;
                }
                if (sudokuSetList.get(i/3).get(j/3).contains(board[i][j])){
                    return false;
                }
                if (rowSetList.get(i).contains(board[i][j])){
                    return false;
                }
                if (colSetList.get(j).contains(board[i][j])){
                    return false;
                }
                sudokuSetList.get(i/3).get(j/3).add(board[i][j]);
                rowSetList.get(i).add(board[i][j]);
                colSetList.get(j).add(board[i][j]);
            }
        }

        return true;
    }
}
