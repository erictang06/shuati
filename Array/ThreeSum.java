package shuati.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.

 Note:
 The solution set must not contain duplicate triplets.

 Example:
 Given array nums = [-1, 0, 1, 2, -1, -4],
 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */

public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> lists = new ArrayList<>();
    if (nums == null || nums.length < 3) {
      return lists;
    }

    Arrays.sort(nums);
    for (int i=0; i<nums.length-2; i++) {
      if (nums[i] > 0) {
        break;
      }
      if (i>0 && nums[i] == nums[i-1]) {
        continue;
      }

      int j = i + 1;
      int k = nums.length - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum == 0) {
          lists.add(Arrays.asList(nums[i], nums[j], nums[k]));
          j++;
          k--;
          while (j < k && nums[j] == nums[j-1]) {
            j++;
          }
          while (j < k && nums[k] == nums[k+1]) {
            k--;
          }
        } else if (sum < 0) {
          j++;
        } else {
          k--;
        }
      }
    }

    return lists;
  }
}
