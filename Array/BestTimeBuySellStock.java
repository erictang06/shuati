package shuati.Array;

public class BestTimeBuySellStock {

  /**
   * v1
   *
   Say you have an array for which the ith element is the price of a given stock on day i.
   If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
   design an algorithm to find the maximum profit.

   Note that you cannot sell a stock before you buy one.

   Example 1:

   Input: [7,1,5,3,6,4]
   Output: 5
   Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
   Not 7-1 = 6, as selling price needs to be larger than buying price.
   * @param prices
   * @return
   */
  public int maxProfitV1(int[] prices) {
    if (prices.length < 2) {
      return 0;
    }

    int maxP = 0;
    int buy = prices[0];
    for (int i = 0; i < prices.length; i++) {
      buy = Math.min(prices[i], buy);
      maxP = Math.max(prices[i] - buy, maxP);
    }

    return maxP;
  }

  /**
   * V2:
   * Say you have an array for which the ith element is the price of a given stock on day i.
   Design an algorithm to find the maximum profit. You may complete as many transactions as you like
   (i.e., buy one and sell one share of the stock multiple times).

   Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

   Example 1:

   Input: [7,1,5,3,6,4]
   Output: 7
   Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
   Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
   */
  public int maxProfitV2a(int[] prices) {
    int total = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      if (prices[i + 1] > prices[i]) {
        total += prices[i + 1] - prices[i];
      }
    }

    return total;
  }

  public int maxProfitV2b(int[] prices) {
    if (prices.length < 2) {
      return 0;
    }

    int maxP = 0;
    int buy = 0;
    boolean bought = false;
    for (int i = 1; i < prices.length; i++) {
      if (!bought && prices[i - 1] < prices[i]) {
        buy = i - 1;
        bought = true;
      }
      if (bought) {
        if (i == prices.length - 1) {
          maxP += (Math.max(prices[i], prices[i - 1]) - prices[buy]);
          return maxP;
        }
        if (prices[i - 1] > prices[i]) {
          maxP += (prices[i - 1] - prices[buy]);
          bought = false;
        }
      }
    }

    return maxP;
  }

  /**
   *
   Say you have an array for which the ith element is the price of a given stock on day i.
   Design an algorithm to find the maximum profit. You may complete at most two transactions.
   Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

   Example 1:

   Input: [3,3,5,0,0,3,1,4]
   Output: 6
   Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
   Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
   * @param prices
   * @return
   */
  /*
  https://soulmachine.gitbooks.io/algorithm-essentials/java/dp/best-time-to-buy-and-sell-stock-iii.html
  设状态f(i)，表示区间[0,i](0 \leq i \leq n-1)[0,i](0≤i≤n−1)的最大利润，
  状态g(i)，表示区间[i, n-1](0 \leq i \leq n-1)[i,n−1](0≤i≤n−1)的最大利润，
  则最终答案为\max\left\{f(i)+g(i)\right\},0 \leq i \leq n-1max{f(i)+g(i)},0≤i≤n−1。
  允许在一天内买进又卖出，相当于不交易，因为题目的规定是最多两次，而不是一定要两次。
  将原数组变成差分数组，本题也可以看做是最大m子段和，m=2，参考代码：https://gist.github.com/soulmachine/5906637
   */
  public int maxProfitV3(int[] prices) {
    if (prices.length < 2) {
      return 0;
    }

    final int n = prices.length;
    int[] f = new int[n];
    int[] g = new int[n];

    for (int i = 1, buy = prices[0]; i < n; ++i) {
      buy = Math.min(buy, prices[i]);
      f[i] = Math.max(f[i - 1], prices[i] - buy);
    }

    for (int i = n - 2, sell = prices[n - 1]; i >= 0; --i) {
      sell = Math.max(sell, prices[i]);
      g[i] = Math.max(g[i], sell - prices[i]);
    }

    int max_profit = 0;
    for (int i = 0; i < n; ++i) {
      max_profit = Math.max(max_profit, f[i] + g[i]);
    }

    return max_profit;
  }
}
