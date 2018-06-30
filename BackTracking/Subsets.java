package shuati.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
  public List<List<Integer>> subsets(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    helper(lists, list, nums, 0);
    return lists;
  }

  private void helper(List<List<Integer>> lists, List<Integer> list, int[] nums, int start) {
    lists.add(new ArrayList<>(list));
    for (int i=start; i<nums.length; i++) {
      list.add(nums[i]);
      helper(lists, list, nums, i+1);
      list.remove(list.size() - 1);
    }
  }
}
