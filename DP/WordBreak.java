package shuati.DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class WordBreak {

  /*

   Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can
   be segmented into a space-separated sequence of one or more dictionary words.

   Note:

   The same word in the dictionary may be reused multiple times in the segmentation.
   You may assume the dictionary does not contain duplicate words.
   Example 1:

   Input: s = "leetcode", wordDict = ["leet", "code"]
   Output: true
   Explanation: Return true because "leetcode" can be segmented as "leet code".
   */

  public boolean wordBreakV1(String s, List<String> wordDict) {
    if (s == null || s.length() == 0) {
      return false;
    }

    // canbeSplitted[i]: true if substring upto index-i can be splitted, false otherwise
    // canbeSplitted[j] is true if canbeSplitted[i] = true && wordDict.contains(s.substring(i, j)

    Boolean[] canSplit = new Boolean[s.length() + 1];
    canSplit[0] = true;

    for (int i = 1; i < s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (canSplit[j] == true && wordDict.contains(s.substring(j, i))) {
          canSplit[i] = true;
          break;
        }
      }
    }

    return canSplit[s.length()];
  }



  /*

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to
construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
   */

  Map<String, List<String>> map = new HashMap<>();

  public List<String> wordBreakV2(String s, List<String> wordDict) {
    Set<String> dict = new HashSet<>(wordDict);
    return wordBreakHelper(s, dict);
  }

  public List<String> wordBreakHelper(String s, Set<String> wordDict) {
    if (map.containsKey(s)) {
      return map.get(s);
    }
    List<String> result = new ArrayList<>();
    for (int j = s.length() - 1; j >= 0; j--) {
      if (wordDict.contains(s.substring(j))) {
        break;
      }
      if (j == 0) {
        return result;
      }
    }

    for (int i = 0; i < s.length() - 1; i++) {
      if (wordDict.contains(s.substring(0, i + 1))) {//contains 0-i
        List<String> rst = wordBreakHelper(s.substring(i + 1, s.length()), wordDict);
        if (rst.size() > 0) {
          Iterator it = rst.iterator();
          while (it.hasNext()) {
            result.add(s.substring(0, i + 1) + " " + it.next());
          }
        }
      }
    }
    if (wordDict.contains(s)) {
      result.add(s);
    }
    map.put(s, result);
    return result;
  }
}
