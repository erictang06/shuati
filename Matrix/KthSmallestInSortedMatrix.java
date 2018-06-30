package shuati.Matrix;

/**
 *
 Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

 Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 */
public class KthSmallestInSortedMatrix {
  /*
  https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code

   Loop invariant:
   There exists a range lo ... hi such that countLessThanOrEquals(matrix, lo) < k and countLessThanOrEquals(hi) >= k

   */

  public int kthSmallest(int[][] matrix, int k) {
    int len = matrix.length;
    int low = matrix[0][0];
    int high = matrix[len - 1][len - 1] + 1;

    while (low < high) {
      int mid = low + (high - low) / 2;
      int count = 0;
      int j = len - 1;
      for (int i = 0; i < len; i++) {
        while (j >= 0 && matrix[i][j] > mid) {
          j--;
        }
        count += (j + 1);
      }
      if (count < k) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }

    return low;
  }
}
