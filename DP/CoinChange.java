package shuati.DP;

import java.util.Arrays;


/**
 *
 You are given coins of different denominations and a total amount of money amount. Write a function to compute the
 fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any
 combination of the coins, return -1.

 Example 1:

 Input: coins = [1, 2, 5], amount = 11
 Output: 3
 Explanation: 11 = 5 + 5 + 1
 Example 2:

 Input: coins = [2], amount = 3
 Output: -1
 */
public class CoinChange {
  public int coinChange(int[] coins, int amount) {
    // f[i]: smallest # of coins for amount i
    // f[i+1] = min{1+f[i-1], 1+f[i-2], ...}

    int[] dp = new int[amount+1];
    Arrays.fill(dp, -1);
    dp[0] = 0;
    for (int i=1; i<=amount; i++) {
      int curMin = Integer.MAX_VALUE;
      for (int coin : coins) {
        if (i >= coin && dp[i-coin] != -1) {
          curMin = Math.min(curMin, dp[i-coin] + 1);
        }
      }
      if (curMin != Integer.MAX_VALUE) {
        dp[i] = curMin;
      }
    }

    return dp[amount];
  }
}
