package shuati.Matrix;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Input:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0

 Output: 4
 */

/**
 * dp[i][j]: the max square for right bottom [i][j]
 * dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
 *
 *
 */
public class MaxSqure {
  public int maximalSquare(char[][] matrix) {
    int lenCol = matrix.length;
    int lenRow = matrix[0].length;

    int maxSize = 0;
    int[][] dp = new int[lenRow][lenCol];
    for (int i = 0; i < lenCol; i++) {
      dp[0][i] = matrix[0][i] - '0';
      maxSize = Math.max(maxSize, dp[0][i]);
    }

    for (int j = 0; j < lenRow; j++) {
      dp[j][0] = matrix[j][0] - '0';
      maxSize = Math.max(maxSize, dp[j][0]);
    }

    for (int indexRow = 1; indexRow < lenRow; indexRow++) {
      for (int indexCol = 1; indexCol < lenCol; indexCol++) {
        if (matrix[indexRow][indexCol] == '0') {
          dp[indexRow][indexCol] = 0;
        } else {
          dp[indexRow][indexCol] =
              Math.min(dp[indexRow - 1][indexCol - 1], Math.min(dp[indexRow - 1][indexCol], dp[indexRow][indexCol - 1]))
                  + 1;
        }

        maxSize = Math.max(maxSize, dp[indexRow][indexCol]);
      }
    }

    return maxSize * maxSize;
  }

  public int maximalSquareV2(char[][] matrix) {
    // f[i][j]: max sq at index [i][j]
    // f[i][j] = 1 if f[i][j] == 1 && all
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    int rowSize = matrix.length;
    int colSize = matrix[0].length;
    int[][] dp = new int[rowSize+1][colSize+1];
    int maxSize = 0;
    for (int i=1; i<=rowSize; i++) {
      for (int j=1; j<=colSize; j++) {
        if (matrix[i-1][j-1] == '1') {
          dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
          maxSize = Math.max(maxSize, dp[i][j]);
        }
      }
    }

    return maxSize * maxSize;
  }
}
