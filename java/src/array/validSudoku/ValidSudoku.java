package array.validSudoku;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Dave Wang
 */
public class ValidSudoku {

    /**
     * 列
     */
    int[] colArr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};

    /**
     * 3 * 3
     */
    int[][] cellColArr = new int[][]{
            new int[]{0, 1, 2},
            new int[]{3, 4, 5},
            new int[]{6, 7, 8},
            new int[]{0, 1, 2},
            new int[]{3, 4, 5},
            new int[]{6, 7, 8},
            new int[]{0, 1, 2},
            new int[]{3, 4, 5},
            new int[]{6, 7, 8}};
    int[][] cellRowArr = new int[][]{
            new int[]{0, 1, 2},
            new int[]{0, 1, 2},
            new int[]{0, 1, 2},
            new int[]{3, 4, 5},
            new int[]{3, 4, 5},
            new int[]{3, 4, 5},
            new int[]{6, 7, 8},
            new int[]{6, 7, 8},
            new int[]{6, 7, 8}};

    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        for (int i = 0; i < n; i++) {
            // 行
            char[] row = board[i];
            if (!check(row)) {
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            // 列
            char[] col = new char[9];
            for (int c = 0; c < colArr.length; c++) {
                col[c] = board[c][i];
            }
            if (!check(col)) {
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            // 3 * 3
            char[] cell = new char[9];
            int j = 0;
            int[] rowIndex = cellRowArr[i];
            int[] colIndex = cellColArr[i];
            for (int k : rowIndex) {
                for (int l : colIndex) {
                    cell[j++] = board[k][l];
                }
            }
            if (!check(cell)) {
                return false;
            }
        }

        return true;
    }

    private boolean check(char[] chars) {
        Set<Character> set = new HashSet<>();
        for (char aChar : chars) {
            if (aChar != '.') {
                if (set.contains(aChar)) {
                    return false;
                } else {
                    set.add(aChar);
                }
            }
        }
        return true;
    }

}
