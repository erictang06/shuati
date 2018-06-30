package shuati;

/**
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets
 * such that the sum of elements in both subsets is equal.

   Note:
   Each of the array element will not exceed 100.
   The array size will not exceed 200.
   Example 1:
   Input: [1, 5, 11, 5]
   Output: true

   Explanation: The array can be partitioned as [1, 5, 5] and [11].
   Example 2:
   Input: [1, 2, 3, 5]
   Output: false
   Explanation: The array cannot be partitioned into equal sum subsets.
 */

public class PartitionEqualSubset {

  /*
    The problem can be transformed to:
    Can we find a subset that sum to sum / 2?
    This is a classic dynamic programming problem.
    利用数组dp[i]记录和为i的子数组是否存在，初始令dp[0] = 1
    The time complexity is O(n2) and the space complexity is O(n),
   */

  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int n : nums) {
      sum += n;
    }
    if (sum % 2 != 0) {
      return false;
    }
    return findWays(nums, sum / 2) != 0;
  }

  public int findWays(int[] nums, int target) {
    int[] ways = new int[target + 1];
    ways[0] = 1;
    for (int num : nums) {
      for (int i = target; i >= num; i--) {
        ways[i] += ways[i - num];
      }
    }
    return ways[target];
  }

  /*
  1、依然数组的和必须要是偶数，否则无法划分，共计n个数,这里价值value/weight都等于nums
  2、将问题转化为背包问题，即取前I个数（物品），和体积j下，dp[i][j]的最大值
      dp[i][j]=max{ dp[i-1][j], dp[i-1][j-nums[i]]+nums[i] }。
  3、这样dp[n][sum/2] 如果等于sum/2 就证明用了这n个数下，正好能加出一个sum/2，所以就自然而然的通过了
   */
  public boolean canPartitionV2(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 2 == 1) {
      return false;
    } else {
      sum /= 2;
      int n = nums.length;
      // dp[i][j] 表示 如果我们取前i个数字，且背包容量为j的情况下，最多能放入多少东西
      int dp[][] = new int[n][sum + 1];
      // dp[0][0] 为初始状态，表示，没有任何没有东西没有体积，其余部分初始化
      for (int i = nums[0]; i <= sum; i++) {
        dp[0][i] = nums[0];
      }
      //遍历n个数字，即视为n个产品
      for (int i = 1; i < n; i++) {
        //加入了这种物品后更新状态
        for (int j = nums[i]; j <= sum; j++) {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
        }
      }
      //放满了才能表示正好1/2
      if (dp[n - 1][sum] == sum) {
        return true;
      } else {
        return false;
      }
    }
  }
}
