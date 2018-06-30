package shuati.Bits;

import java.util.HashMap;
import java.util.Map;


public class SingleNumbers {

  /**
   * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
   Note:
   Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

   Example 1:
   Input: [2,2,3,2]
   Output: 3
   Example 2:
   Input: [0,1,0,1,0,1,99]
   Output: 99
   */

  // do a 3-based calculation / 3-state counter
  /*
  /* 3-state counter
   'A'  'twos'  'ones'    'twos'  'ones'
    0      0       0    |    0       0  -> 0 + 0 = 0
    0      0       1    |    0       1  -> 0 + 1 = 1
    0      1       0    |    1       0  -> 0 + 2 = 2
    1      0       0    |    0       1  -> 1 + 0 = 0
    1      0       1    |    1       0  -> 1 + 1 = 2
    1      1       0    |    0       0  -> 1 + 2 = 10

    for (int i = 0; i < A.size(); i++) {
    ones = (ones ^ a[i]) & ~twos;
    twos = (twos ^ a[i]) & ~ones;
  }

   */
  public int singleNumber(int[] A) {
    int ones = 0, twos = 0;
    for (int i = 0; i < A.length; i++) {
      ones = (ones ^ A[i]) & ~twos;
      twos = (twos ^ A[i]) & ~ones;
    }

    Map<Integer, Integer> map = new HashMap<>();
    for (Integer i : map.values()) {

    }

    return ones;
  }
}
