package shuati.Array;

import java.util.Arrays;


public class ProdWithoutSelf {
  // https://leetcode.com/problems/product-of-array-except-self/discuss/65622/Simple-Java-solution-in-O(n)-without-extra-space

  // with constant memory
  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    res[0] = 1;
    for (int i = 1; i < n; i++) {
      res[i] = res[i - 1] * nums[i - 1];
    }
    int right = 1;
    for (int i = n - 1; i >= 0; i--) {
      res[i] *= right;
      right *= nums[i];
    }
    return res;
  }

  // my owner version with additional arrays
  public int[] productExceptSelfV2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return nums;
    }

    int[] before = new int[nums.length];
    int[] after = new int[nums.length];
    Arrays.fill(before, 1);
    Arrays.fill(after, 1);
    for (int i = 1; i < nums.length; i++) {
      before[i] = before[i - 1] * nums[i - 1];
    }
    for (int j = nums.length - 2; j >= 0; j--) {
      after[j] = after[j + 1] * nums[j + 1];
    }
    int[] result = new int[nums.length];
    for (int k = 0; k < nums.length; k++) {
      result[k] = before[k] * after[k];
    }

    return result;
  }
}
