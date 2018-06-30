package shuati.Array;

/**
 *
 Given an integer array nums, find the contiguous subarray within an array (containing at least one number)
 which has the largest product.

 Example 1:

 Input: [2,3,-2,4]
 Output: 6
 Explanation: [2,3] has the largest product 6.
 Example 2:

 Input: [-2,0,-1]
 Output: 0
 Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaxProdSubarray {
  public int maxProduct(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }

    // f[i]: max of subarray ending at index i
    int maxProd = nums[0];
    int curMin = maxProd;
    int curMax = maxProd;
    for (int i=1; i<nums.length; i++) {
      if (nums[i] < 0) {
        int tmp = curMin;
        curMin = curMax;
        curMax = tmp;
      }

      curMin = Math.min(nums[i], curMin * nums[i]);
      curMax = Math.max(nums[i], curMax * nums[i]);
      maxProd = Math.max(curMax, maxProd);
    }

    return maxProd;
  }
}
