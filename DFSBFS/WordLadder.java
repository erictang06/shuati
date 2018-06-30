package shuati.DFSBFS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
 * sequence from beginWord to endWord, such that:
 *  Only one letter can be changed at a time.
 *  Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

 Note:

 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.
 */
public class WordLadder {

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> dict = new HashSet<>(wordList);

    int distance = 1; // not 0 because in line 40-47
    if (!dict.contains(endWord)) {
      return 0;
    }
    Set<String> reached = new HashSet<>();
    reached.add(beginWord);

    while (!reached.contains(endWord)) {
      Set<String> pathSet = new HashSet<>();

      for (String word : reached) {
        for (int i = 0; i < word.length(); i++) {
          char[] chars = word.toCharArray();
          for (char c = 'a'; c <= 'z'; c++) {
            chars[i] = c;
            String current = new String(chars);
            if (dict.contains(current)) {
              pathSet.add(current);
              dict.remove(current);
            }
          }
        }
      }
      distance++;
      if (pathSet.size() == 0) {
        return 0;
      }

      reached = pathSet;
    }

    return distance;
  }
}
