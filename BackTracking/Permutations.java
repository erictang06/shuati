package shuati.BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Given a collection of distinct integers, return all possible permutations.
 */
public class Permutations {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    backtrack(lists, list, nums);
    return lists;
  }

  private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
    if (tempList.size() == nums.length) {
      list.add(new ArrayList<>(tempList));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (tempList.contains(nums[i])) {
          continue; // element already exists, skip
        }
        tempList.add(nums[i]);
        backtrack(list, tempList, nums);
        tempList.remove(tempList.size() - 1);
      }
    }
  }

  public List<List<Integer>> permute1(int[] nums) {
    List<List<Integer>> lists = new ArrayList<>();
    helper2(lists, nums, 0);
    return lists;
  }

  public void helper2(List<List<Integer>> lists, int[] nums, int start) {
    // 找到转置完成后的解，将其存入列表中
    if (start == nums.length - 1) {
      List<Integer> list = new ArrayList<>();
      for (int j = 0; j < nums.length; j++) {
        list.add(nums[j]);
      }
      lists.add(list);
    }
    // 将当前位置的数跟后面的数交换，并搜索解
    for (int j = start; j < nums.length; j++) {
      swap(nums, start, j);
      helper2(lists, nums, start + 1);
      swap(nums, start, j);
    }
  }

  /*
  Given a collection of numbers that might contain duplicates, return all possible unique permutations.
    Example:
    Input: [1,1,2]
    Output:
    [
      [1,1,2],
      [1,2,1],
      [2,1,1]
    ]
   */
  private void helper(List<List<Integer>> lists, int[] nums, int start) {
    if (start == nums.length - 1) {
      List<Integer> list = new ArrayList<>();
      for (Integer num : nums) {
        list.add(num);
      }
      lists.add(list);
    }
    else {
      Set<Integer> set = new HashSet<>();
      for (int i=start; i<nums.length; i++) {
        if (set.add(nums[i])) {
          swap(nums, i, start);
          helper(lists, nums, start+1);
          swap(nums, i, start);
        }
      }
    }
  }



  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}