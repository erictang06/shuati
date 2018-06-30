package shuati.Math;

import java.util.ArrayList;
import java.util.List;


/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
 A gray code sequence must begin with 0.

 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2
 Note:
 For a given n, a gray code sequence is not uniquely defined.

 For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 */
public class GrayCode {
  //  https://leetcode.com/problems/gray-code/discuss/29891/Share-my-solution
  /*
  My idea is to generate the sequence iteratively. For example, when n=3, we can get the result based on n=2.
  00,01,11,10 -> (000,001,011,010 ) (110,111,101,100). The middle two numbers only differ at their highest bit,
  while the rest numbers of part two are exactly symmetric of part one. It is easy to see its correctness.
  Code is simple:
   */

  public List<Integer> grayCode(int n) {
    List<Integer> list = new ArrayList<>();

    list.add(0); // always starts from 0000 anyway
    for (int i=0; i<n; i++) {
      int size = list.size();
      for (int k=size-1; k>=0; k--) {
        list.add(list.get(k) | 1 << i);
      }
    }

    return list;
  }


}
