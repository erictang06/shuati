package shuati.String;

import java.util.ArrayList;
import java.util.List;


/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ;
 *
 * otherwise, it will return false.

 Each letter in the magazine string can only be used once in your ransom note.

 Note:
 You may assume that both strings contain only lowercase letters.

 canConstruct("a", "b") -> false
 canConstruct("aa", "ab") -> false
 canConstruct("aa", "aab") -> true
 */
public class RansomNotes {
  public boolean canConstruct(String ransomNote, String magazine) {
    if (ransomNote == null || magazine == null || ransomNote.length() > magazine.length()) {
      return false;
    }
    List<Character> mlist = new ArrayList<>();
    for (char ch : magazine.toCharArray()) {
      mlist.add(ch);
    }
    for (int i=0; i<ransomNote.length(); i++) {
      if (!mlist.contains(ransomNote.charAt(i))) {
        return false;
      }
      mlist.remove(mlist.indexOf(ransomNote.charAt(i)));
    }

    return true;
  }
}
