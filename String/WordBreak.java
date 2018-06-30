package shuati.String;

import java.util.List;


/**
 *
   Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s
   can be segmented into a space-separated sequence of one or more dictionary words.

   Note:
   The same word in the dictionary may be reused multiple times in the segmentation.
   You may assume the dictionary does not contain duplicate words.
 */

public class WordBreak {
  public boolean wordBreak(String s, List<String> wordDict) {
    if (s == null || s.length() == 0) {
      return false;
    }

    // canbeSplitted[i]: true if substring upto index-i can be splitted, false otherwise
    // canbeSplitted[j] is true if canbeSplitted[i] = true && wordDict.contains(s.substring(i, j)

    Boolean[] canbeSplitted = new Boolean[s.length() + 1];
    canbeSplitted[0] = true;

    for (int i=1; i<s.length(); i++) {
      for (int j=0; j<i; j++) {
        if (canbeSplitted[j] == true && wordDict.contains(s.substring(j, i))) {
          canbeSplitted[i] = true;
          break;
        }
      }
    }

    return canbeSplitted[s.length()];
  }
}