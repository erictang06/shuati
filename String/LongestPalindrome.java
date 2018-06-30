package shuati.String;

public class LongestPalindrome {

    /*
    Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

    Example 1:
    Input: "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.
    Example 2:

    Input: "cbbd"
    Output: "bb"
   */

  public String longestPalindrome(String s) {
    if (s == null || s.length() < 2) {
      return s;
    }

    int len = s.length();
    String maxString = "";

    for (int i=0; i<len; i++) {
      String s1 = extendString(s, i, i);
      if (s1.length() > maxString.length()) {
        maxString = s1;
      }
      String s2 = extendString(s, i, i+1);
      if (s2.length() > maxString.length()) {
        maxString = s2;
      }
    }

    return maxString;
  }
  private String extendString(String s, int backward, int forward) {
    while (backward >=0 && forward<s.length() && s.charAt(backward) == s.charAt(forward)) {
      backward--;
      forward++;
    }

    return s.substring(backward+1, forward);
  }
}
