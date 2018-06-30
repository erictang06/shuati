package shuati.Matrix;

/**
 *
 Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes
 the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.

 Example:

 Input:
 [
 [1,3,1],
 [1,5,1],
 [4,2,1]
 ]
 Output: 7
 Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinPathSum {
  public int minPathSum(int[][] grid) {
    int rowSize = grid.length;
    int colSize = grid[0].length;

    int[][] dp = new int[rowSize][colSize];
    dp[0][0] = grid[0][0];
    for (int i=1; i<colSize; i++) {
      dp[0][i] = grid[0][i] + dp[0][i-1];
    }
    for (int j=1; j<rowSize; j++) {
      dp[j][0] = grid[j][0] + dp[j-1][0];
    }

    for (int i=1; i<rowSize; i++) {
      for (int j=1; j<colSize; j++) {
        dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
      }
    }

    return dp[rowSize-1][colSize-1];
  }
}
