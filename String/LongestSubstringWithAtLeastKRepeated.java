package shuati.String;

import java.util.Arrays;


// TODO: have not done it, just copied the solutions

/**
 *
 Find the length of the longest substring T of a given string (consists of lowercase letters only) such that
 every character in T appears no less than k times.

 Example 1:
 Input:
 s = "aaabb", k = 3
 Output:
 3
 The longest substring is "aaa", as 'a' is repeated 3 times.

 Example 2:
 Input:
 s = "ababbc", k = 2
 Output:
 5

 The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */
public class LongestSubstringWithAtLeastKRepeated {
//  https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/discuss/87739/Java-Strict-O(N)-Two-Pointer-Solution
  /*
    This is just brutal force all possible sub strings with two indices.
    The algorithm explanation: find sub strings with only 1 kind of letter that repeated at least k times.
    then find the sub string with 2 kind of letters that repeated at least k times. ...
     find sub string with all 26 kind of letters that repeated at least k times.
    For each loop, it first check if the different letters exceeds current loop requirement,
    if so, keep getting rid of the last char of current sub string until the number of different letters reduced to current loop limit.
    When not exceed limit continue the iteration, and when the sub string matches the at least repeat k times condition, update max.
    It may look stupid, but it's actually O(N) time complexity.
   */
  public int longestSubstring(String s, int k) {
    char[] str = s.toCharArray();
    int[] counts = new int[26];
    int h, i, j, idx, max = 0, unique, noLessThanK;

    for (h = 1; h <= 26; h++) {
      Arrays.fill(counts, 0);
      i = 0;
      j = 0;
      unique = 0;
      noLessThanK = 0;
      while (j < str.length) {
        if (unique <= h) {
          idx = str[j] - 'a';
          if (counts[idx] == 0)
            unique++;
          counts[idx]++;
          if (counts[idx] == k)
            noLessThanK++;
          j++;
        }
        else {
          idx = str[i] - 'a';
          if (counts[idx] == k)
            noLessThanK--;
          counts[idx]--;
          if (counts[idx] == 0)
            unique--;
          i++;
        }
        if (unique == h && unique == noLessThanK)
          max = Math.max(j - i, max);
      }
    }

    return max;
  }
}
