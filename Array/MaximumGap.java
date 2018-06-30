package shuati.Array;

import java.util.Arrays;


/**
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

 Return 0 if the array contains less than 2 elements.

 Example 1:

 Input: [3,6,9,1]
 Output: 3
 Explanation: The sorted form of the array is [1,3,6,9], either
 (3,6) or (6,9) has the maximum difference 3.
 Example 2:

 Input: [10]
 Output: 0
 Explanation: The array contains less than 2 elements, therefore return 0.
 */
public class MaximumGap {
// https://blog.csdn.net/u012162613/article/details/41936569 => explained pretty well along with this:
//  https://leetcode.com/problems/maximum-gap/discuss/50643/bucket-sort-JAVA-solution-with-explanation-O(N)-time-and-space

  public int maximumGap(int[] nums) {
    if (nums == null || nums.length < 2) {
      return 0;
    }
    // get the max and min value of the array
    int minVal = nums[0];
    int maxVal = nums[0];
    for (int num : nums) {
      minVal = Math.min(minVal, num);
      maxVal = Math.max(maxVal, num);
    }

    // the minimum possible gap, ceiling of the integer division
    int gap = (int) Math.ceil((double) (maxVal - minVal) / (nums.length - 1));
    int[] minBucket = new int[nums.length - 1]; // store the min value in that bucket
    int[] maxBucket = new int[nums.length - 1]; // store the max value in that bucket
    Arrays.fill(minBucket, Integer.MAX_VALUE);
    Arrays.fill(maxBucket, Integer.MIN_VALUE);

    // put numbers into buckets
    for (int num : nums) {
      if (num == minVal || num == maxVal) {
        continue;
      }
      int idx = (num - minVal) / gap; // index of the right position in the buckets
      minBucket[idx] = Math.min(num, minBucket[idx]);
      maxBucket[idx] = Math.max(num, maxBucket[idx]);
    }

    // scan the buckets for the max gap
    int maxGap = Integer.MIN_VALUE;
    int previous = minVal;
    for (int i = 0; i < nums.length - 1; i++) {
      if (minBucket[i] == Integer.MAX_VALUE && maxBucket[i] == Integer.MIN_VALUE) {
        continue;       // empty bucket
      }

      // min value minus the previous value is the current gap
      maxGap = Math.max(maxGap, minBucket[i] - previous);
      // update previous bucket value
      previous = maxBucket[i];
    }

    maxGap = Math.max(maxGap, maxVal - previous); // updata the final max value gap
    return maxGap;
  }
}
