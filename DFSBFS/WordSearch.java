package shuati.DFSBFS;

/**
 *
 Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
 or vertically neighboring. The same letter cell may not be used more than once.

 Example:

 board =
 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]

 Given word = "ABCCED", return true.
 Given word = "SEE", return true.
 Given word = "ABCB", return false.
 */
public class WordSearch {
  private boolean[][] visited;

  public boolean exist(char[][] board, String word) {
    if (board == null || board.length == 0 || word == null || word.length() == 0) {
      return false;
    }

    visited = new boolean[board.length][board[0].length];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == word.charAt(0) && helper(board, word, i, j, 0)) {
          return true;
        }
      }
    }

    return false;
  }

  private boolean helper(char[][] board, String word, int rowIndex, int colIndex, int steps) {
    if (steps == word.length()) {
      return true;
    }

    if (rowIndex >= board.length || rowIndex < 0 || colIndex >= board[0].length || colIndex < 0
        || board[rowIndex][colIndex] != word.charAt(steps) || visited[rowIndex][colIndex]) {
      return false;
    }

    visited[rowIndex][colIndex] = true;
    if (helper(board, word, rowIndex - 1, colIndex, steps + 1) || helper(board, word, rowIndex + 1, colIndex, steps + 1)
        || helper(board, word, rowIndex, colIndex - 1, steps + 1) || helper(board, word, rowIndex, colIndex + 1,
        steps + 1)) {
      return true;
    }
    visited[rowIndex][colIndex] = false;
    return false;
  }
}
