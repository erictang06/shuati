package shuati.Array;

// https://leetcode.com/problems/search-in-rotated-sorted-array/description/

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

 You are given a target value to search. If found in the array return its index, otherwise return -1.
 You may assume no duplicate exists in the array.

 Your algorithm's runtime complexity must be in the order of O(log n).

 Example 1:

 Input: nums = [4,5,6,7,0,1,2], target = 0
 Output: 4
 Example 2:

 Input: nums = [4,5,6,7,0,1,2], target = 3
 Output: -1
 */
public class SearchRotatedArray {
  // https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14425/Concise-O(log-N)-Binary-search-solution

  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int start = 0, end = nums.length - 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      boolean isLeftSorted = isSorted(nums, start, mid);
      boolean isRightSorted = isSorted(nums, mid, end);
      if (isLeftSorted && target >= nums[start] && target < nums[mid]) {
        end = mid - 1;
      } else if (isRightSorted && target > nums[mid] && target <= nums[end]) {
        start = mid + 1;
      } else {
          // left part is sorted but target does not lie in sorted part (as above conditions are false) ,
          // hence search in rotated right part
          if (isLeftSorted) {
            start = mid + 1;
        } else {
            // right part is sorted but target does not lie in right sorted part (as above conditions are false),
            // hence search in rotated left part
            end = mid - 1;
        }
      }
    }
    return -1;
  }

  private boolean isSorted(int[] nums, int start, int end) {
    if (nums[end] > nums[start] || start == end) {
      //single element is sorted
      return true;
    }
    return false;
  }
}
