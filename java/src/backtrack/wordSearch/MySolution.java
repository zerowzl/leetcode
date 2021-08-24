package backtrack.wordSearch;


import java.util.ArrayList;
import java.util.List;

/**
 * 79. 单词搜索
 *
 * @author Dave Wang
 */
class MySolution {

    boolean exist = false;

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }

        char[] wordChars = word.toCharArray();
        List<Character> wordList = new ArrayList<>(wordChars.length);
        for (char wordChar : wordChars) {
            wordList.add(wordChar);
        }

        int m = board.length;
        int n = board[0].length;
        // 记录是否访问过
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exist) {
                    return true;
                }
                backstack(board, wordList, visited, i, j, m, n, 0);
            }
        }

        return exist;
    }

    private void backstack(char[][] board, List<Character> wordList, boolean[][] visited,
                           int i, int j, int m, int n, int wordIndex) {
        // 找到了
        if (wordIndex == wordList.size()) {
            exist = true;
            return;
        }

        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }

        // 当前一样 继续搜索上下左右
        if (board[i][j] == wordList.get(wordIndex) && !visited[i][j]) {
            // 访问过
            visited[i][j] = true;
            backstack(board, wordList, visited, i - 1, j, m, n, wordIndex + 1);
            backstack(board, wordList, visited, i + 1, j, m, n, wordIndex + 1);
            backstack(board, wordList, visited, i, j - 1, m, n, wordIndex + 1);
            backstack(board, wordList, visited, i, j + 1, m, n, wordIndex + 1);
            // 回溯后恢复现场
            visited[i][j] = false;
        }
    }
}