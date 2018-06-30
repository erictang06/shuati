package shuati.DP;

/**
 *
 Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

 Example 1:

 Input: n = 12
 Output: 3
 Explanation: 12 = 4 + 4 + 4.
 Example 2:

 Input: n = 13
 Output: 2
 Explanation: 13 = 4 + 9.
 */
public class PerfectSquare {
  // https://leetcode.com/problems/perfect-squares/discuss/71495/An-easy-understanding-DP-solution-in-Java

  public int numSquares(int n) {

    // now we have a list of square numbers no greater than n
    // convert to min change problem
    int[] dp = new int[n + 1];
    // Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
      int min = Integer.MAX_VALUE;
      int j = 1;
      while (i - j * j >= 0) {
        min = Math.min(min, 1 + dp[i - j * j]);
        j++;
      }
      dp[i] = min;
    }

    return dp[n];
  }
}