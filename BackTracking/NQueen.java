package shuati.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class NQueen {

  public List<List<String>> solveNQueens(int n) {
    char[][] board = new char[n][n];
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < n; col++) {
        board[row][col] = '.';
      }
    }
    List<List<String>> res = new ArrayList<>();
    dfs(board, 0, res);
    return res;
  }

  private void dfs(char[][] board, int index, List<List<String>> res) {
    if (index == board.length) {
      res.add(construct(board));
      return;
    }

    for (int i = 0; i < board.length; i++) {
      if (validate(board, i, index)) {
        board[i][index] = 'Q';
        dfs(board, index + 1, res);
        board[i][index] = '.';
      }
    }
  }

  private boolean validate(char[][] board, int row, int col) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < col; j++) {
        if (board[i][j] == 'Q' && (row + j == col + i || row + col == i + j || row == i)) {
          return false;
        }
      }
    }

    return true;
  }

  private List<String> construct(char[][] board) {
    List<String> res = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      String s = new String(board[i]);
      res.add(s);
    }
    return res;
  }
}
