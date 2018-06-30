package shuati.BackTracking;

import java.util.ArrayList;


public class WinGame {
}

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

// board = [1, 3, 2, 0, 5, 2, 8, 2]
//                         ^

// winGame should return True if you can end up on a 0 in the array

// winGame(board, startingPos)
// winGame(board, 0) == False
// winGame(board, 3) == True
// winGame(board, 5) == True

// p[0] -> p[1] -> p[4] -> end
// winGame(board, 0) = true

class Solution {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java 8.");

    for (String string : strings) {
      System.out.println(string);
    }

    Solution mySolution = new Solution();
    int[] board = new int[] {1, 3, 2, 0, 5, 2, 8, 2};

    boolean can = mySolution.winGame(board, 0);
    System.out.println(can);

    can = mySolution.winGame(board, 7);
    System.out.println(can);
  }


  public boolean winGame(int[] board, int start) {
    if (board == null || board.length == 0) {
      return false;
    }

    int len = board.length;
    boolean[] visited = new boolean[len];

    if (start <0 || start >= len) {
      return false;
    }

    // visited[start] = true;

    return helper(board, visited, start);
    // return true/false;
  }

  /**
   doc
   */
  private boolean helper(int[] board, boolean[] visited, int start) {

    if (board[start] == 0) {
      return true;
    }

    if (visited[start] == true) {
      return false;
    }

    visited[start] = true;
    boolean canLeft = false;
    boolean canRight = false;

    if (start + board[start] < board.length) {
      canRight = helper(board, visited, start + board[start]);
      // visited[start + board[start]] = false;
    }
    if (start - board[start] >= 0) {
      canLeft = helper(board, visited, start - board[start]);
      // visited[start - board[start]] = false;
    }

    visited[start] = false;
    return canLeft || canRight;
  }
}