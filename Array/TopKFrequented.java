package shuati.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].
 */

public class TopKFrequented {
  public List<Integer> topKFrequent(int[] nums, int k) {
    List<Integer> result = new ArrayList<>();

    if (nums == null || nums.length == 0 || k <= 0) {
      return result;
    }

    Map<Integer, Integer> map2 = new HashMap<>(); // map of <index, freq(index)>
    for (int n : nums) {
      map2.put(n, map2.getOrDefault(n, 0) + 1);
    }

    Map<Integer, Integer> map = new HashMap<>();
    for (Integer num : nums) {
      if (map.containsValue(num)) {
        map.put(map.get(num) + 1, num);
      } else {
        map.put(num, 1);
      }
    }

    Integer[] array = (Integer[]) (map.keySet().toArray());
    Arrays.sort(array);
    for (int i = 0; i < k; i++) {
      result.add(map.get(array[i]));
    }

    return result;
  }
}