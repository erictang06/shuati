package shuati.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CombinationSums {
  /**
   * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
   * find all unique combinations in candidates where the candidate numbers sums to target.
   * The same repeated number may be chosen from candidates unlimited number of times.

   Note:

   All numbers (including target) will be positive integers. The solution set must not contain duplicate combinations.
   Example 1:

   Input: candidates = [2,3,6,7], target = 7,
   A solution set is: [[7],[2,2,3]]
   */

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    Arrays.sort(candidates);
    helper(lists, list, candidates, target, 0);
    return lists;
  }

  private void helper(List<List<Integer>> lists, List<Integer> list, int[] candidates, int target, int start) {
    if (target < 0) {
      return;
    }

    if (target == 0) {
      lists.add(new ArrayList(list));
    } else {
      for (int i = start; i < candidates.length; i++) {
        list.add(candidates[i]);
        helper(lists, list, candidates, target - candidates[i], i);
        list.remove(list.size() - 1);
      }
    }
  }

  /**
   *
   Given a collection of candidate numbers (candidates) and a target number (target),
   find all unique combinations in candidates where the candidate numbers sums to target.
   Each number in candidates may only be used once in the combination.

   Note:
   All numbers (including target) will be positive integers. The solution set must not contain duplicate combinations.

   Example 1:

   Input: candidates = [10,1,2,7,6,1,5], target = 8,
   A solution set is:
   [[1, 7],[1, 2, 5],[2, 6], [1, 1, 6]]
   */

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    Arrays.sort(candidates);
    helper2(lists, list, candidates, target, 0);
    return lists;
  }

  public void helper2(List<List<Integer>> lists, List<Integer> list, int[] candidates, int target, int start) {
    if (target < 0) {
      return;
    }

    if (target == 0) {
      lists.add(new ArrayList(list));
    } else {
      for (int i = start; i < candidates.length; i++) {
        if (i > start && candidates[i] == candidates[i - 1]) {
          continue;
        }
        list.add(candidates[i]);
        helper2(lists, list, candidates, target - candidates[i], i + 1);
        list.remove(list.size() - 1);
      }
    }
  }
}
