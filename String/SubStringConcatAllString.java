package shuati.String;

/*
    https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/

    You are given a string, s, and a list of words, words, that are all of the same length.
    Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once
    and without any intervening characters.

    Example 1:

    Input:
      s = "barfoothefoobarman",
      words = ["foo","bar"]
    Output: [0,9]
    Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
    The output order does not matter, returning [9,0] is fine too.
    Example 2:

    Input:
      s = "wordgoodstudentgoodword",
      words = ["word","student"]
    Output: []
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SubStringConcatAllString {
  //  https://simpleandstupid.com/2014/10/21/substring-with-concatenation-of-all-words-leetcode-%E8%A7%A3%E9%A2%98%E7%AC%94%E8%AE%B0/
  /*
  Try to think this problem straightforward:
    Say in L there are m strings with length n.
    What string is required to match in S? A length of m*n string start with each position in S.
    What is a match? In the m*n long string, every string in L appear only once.

  So the algorithm is:
    Scan every m*n long string start from each position in S, see if all the strings in L have been appeared only once
    using Map data structure. If so, store the starting position.
   */
  public List<Integer> findSubstring(String s, String[] words) {
    // Start typing your Java solution below
    if (words == null || words.length == 0) {
      return null;
    }
    int numWords = words.length;
    int lenWord = words[0].length();
    int lenS = s.length();

    ArrayList<Integer> res = new ArrayList<>();
    Map<String, Integer> covered = new HashMap<>();

    for (int j = 0; j < numWords; j++) {
      if (covered.containsKey(words[j])) {
        covered.put(words[j], covered.get(words[j]) + 1);
      } else {
        covered.put(words[j], 1);
      }
    }

    int i = 0;
    while (lenS - i >= numWords * lenWord) {
      Map<String, Integer> temp = new HashMap<>(covered);
      for (int j = 0; j < numWords; j++) {
        String testStr = s.substring(i + j * lenWord, i + (j + 1) * lenWord);
        if (temp.containsKey(testStr)) {
          if (temp.get(testStr) == 1) {
            temp.remove(testStr);
          } else {
            temp.put(testStr, temp.get(testStr) - 1);
          }
        } else {
          break;
        }
      }
      if (temp.size() == 0) {
        res.add(i);
      }
      i++;
    }
    return res;
  }
}