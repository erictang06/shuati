package shuati.Matrix;

import java.util.ArrayList;
import java.util.List;


/**
 *
 Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 Example 1:

 Input:
 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 Output: [1,2,3,6,9,8,7,4,5]
 Example 2:

 Input:
 [
 [1, 2, 3, 4],
 [5, 6, 7, 8],
 [9,10,11,12]
 ]
 Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrixPrinting {

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> list = new ArrayList<>();
    if (matrix == null || matrix.length == 0) {
      return list;
    }
    int rowSize = matrix.length;
    int colSize = matrix[0].length;
    int rowBegin = 0;
    int rowEnd = rowSize - 1;
    int colBegin = 0;
    int colEnd = colSize - 1;

    while (rowBegin <= rowEnd && colBegin <= colEnd) {
      // traverse right
      for (int i = colBegin; i <= colEnd; i++) {
        list.add(matrix[rowBegin][i]);
      }
      rowBegin++;

      // traverse down
      for (int j = rowBegin; j <= rowEnd; j++) {
        list.add(matrix[j][colEnd]);
      }
      colEnd--;

      // traverse left if needed
      if (rowBegin <= rowEnd) {
        for (int m = colEnd; m >= colBegin; m--) {
          list.add(matrix[rowEnd][m]);
        }
      }
      rowEnd--;

      // traverse up if needed
      if (colBegin <= colEnd) {
        for (int n = rowEnd; n >= rowBegin; n--) {
          list.add(matrix[n][colBegin]);
        }
      }
      colBegin++;
    }

    return list;
  }

  /*
  Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
   */
  public int[][] generateMatrix(int n) {
    int rowBegin = 0;
    int rowEnd = n - 1;
    int colBegin = 0;
    int colEnd = n - 1;

    int mat[][] = new int[n][n];
    int count = 0;
    while (count < n * n) {
      for (int i = colBegin; i <= colEnd; i++) {
        mat[rowBegin][i] = count + 1;
        count++;
      }
      rowBegin++;

      for (int j = rowBegin; j <= rowEnd; j++) {
        mat[j][colEnd] = count + 1;
        count++;
      }
      colEnd--;

      for (int m = colEnd; m >= colBegin; m--) {
        mat[rowEnd][m] = count + 1;
        count++;
      }
      rowEnd--;

      for (int k = rowEnd; k >= rowBegin; k--) {
        mat[k][colBegin] = count + 1;
        count++;
      }
      colBegin++;
    }

    return mat;
  }
}
