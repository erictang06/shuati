package shuati.Array;

/**
 *
 Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 Example 1:

 Input: nums = [5,7,7,8,8,10], target = 8
 Output: [3,4]
 Example 2:

 Input: nums = [5,7,7,8,8,10], target = 6
 Output: [-1,-1]
 */
public class SearchRange {
  public int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length < 1) {
      return new int[]{-1, -1};
    }

    int start = findFirstGreaterOrEqual(nums, target);
    if (start == nums.length || nums[start] != target) {
      return new int[]{-1, -1};
    }
    return new int[]{start, findFirstGreaterOrEqual(nums, target + 1) - 1};
  }

  private int findFirstGreaterOrEqual(int[] nums, int target) {
    int low = 0;
    int high = nums.length;
    while (low < high) {
      int mid = low + ((high - low) >> 1);
      if (nums[mid] < target) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }

    return low;
  }
}
