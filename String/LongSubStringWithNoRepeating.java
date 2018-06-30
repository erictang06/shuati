package shuati.String;

import java.util.HashMap;
import java.util.Map;


/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Basic idea:
 *   using a hashmap<Char, Int> to keep track of the location of the chars
 *   scan the string from left to right, if not seeing a repeated char, put the char, if yes, record length, replace index
 */
public class LongSubStringWithNoRepeating {
  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();

    int len = s.length();
    int left = 0;
    int right;
    int maxLen = 0;

    for (right=0; right<len; right++) {
      if (map.containsKey(s.charAt(right))) {
        left = Math.max(left, map.get(s.charAt(right))+1);
      }
      map.put(s.charAt(right), right);
      maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
  }
}
