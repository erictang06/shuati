package shuati.BackTracking;

import java.util.ArrayList;
import java.util.List;


/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 Example:

 Input: n = 4, k = 2
 Output:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */
public class Combinations {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    helper(lists, list, n, k, 1);
    return lists;
  }

  private void helper(List<List<Integer>> lists, List<Integer> list, int n, int k, int start) {
    if (list.size() == k) {// to re-think
      List<Integer> alist = new ArrayList<>(list);
      lists.add(alist);
    }

    for (int i=start; i<n; i++) {
      list.add(i);
      helper(lists, list, n, k, i+1);
      list.remove(list.size()-1);
    }
  }
}
