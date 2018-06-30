package shuati.Array;

/**
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

 Formally the function should:
 Return true if there exists i, j, k
 such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 Your algorithm should run in O(n) time complexity and O(1) space complexity.

 Examples:
 Given [1, 2, 3, 4, 5],
 return true.

 Given [5, 4, 3, 2, 1],
 return false.

 */
public class IncreasingTriplet {
  // http://www.cnblogs.com/grandyang/p/5194599.html
  /*
  思路是使用两个指针m1和m2，初始化为整型最大值，我们遍历数组，如果m1大于等于当前数字，则将当前数字赋给m1；如果m1小于当前数字且m2大于等于当前数字，
  那么将当前数字赋给m2，一旦m2被更新了，说明一定会有一个数小于m2，那么我们就成功的组成了一个长度为2的递增子序列，所以我们一旦遍历到比m2还大的数，
  我们直接返回true。如果我们遇到比m1小的数，还是要更新m1，有可能的话也要更新m2为更小的值，毕竟m2的值越小，能组成长度为3的递增序列的可能性越大
   */

  public boolean increasingTriplet(int[] nums) {
    int small = Integer.MAX_VALUE;
    int big = Integer.MAX_VALUE;

    // small is the smallest, big is the 2nd smallest
    // adjust small and big as we go along
    for (Integer num : nums) {
      if (num <= small) {
        small = num;
      } else if (num <= big) {
        big = num;
      } else {
        return true;
      }
    }

    return false;
  }
}
