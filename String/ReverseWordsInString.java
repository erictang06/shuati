package shuati.String;

/**
 * Given an input string, reverse the string word by word.

   Example:

   Input: "the sky is blue",
   Output: "blue is sky the".
   Note:

   A word is defined as a sequence of non-space characters.
   Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
   You need to reduce multiple spaces between two words to a single space in the reversed string.
 */

public class ReverseWordsInString {
  public String reverseWords(String s) {
    if (s == null) {
      return null;
    }

    char[] charArray = s.toCharArray();
    int len = charArray.length;

    // step 1. reverse the whole string
    reverse(charArray, 0, len - 1);
    // step 2. reverse each word
    reverseWords(charArray, len);
    // step 3. clean up spaces
    return cleanSpaces(charArray, len);
  }

  /*
  i and j both starts from 0, i is the start pointer, j is the end pointer
    (1) while(i<n && a[i]==' ') i++ is to skip the leading spaces before every word.
    (2) while (j<i) points j to the same position as i, because i has already skipped the leading spaces in prior while
    (3) while(j<n && a[j]!=' ') find the whole word starts from i, ends at j until a[j] is ' ' or j<n
    (4) while(i<j) i is the start index of last word, j-1 is the end index of the last word,
        points i to the same position as j, then start finding the next word
   */
  void reverseWords(char[] chars, int len) {
    int start = 0, end = 0;

    while (start < len) {
      while (start < end || start < len && chars[start] == ' ') {
        start++; // skip spaces
      }
      while (end < start || end < len && chars[end] != ' ') {
        end++; // skip non spaces
      }
      reverse(chars, start, end - 1);   // reverse the word
    }
  }

  // trim leading, trailing and multiple spaces
  String cleanSpaces(char[] chars, int len) {
    int i = 0, j = 0;

    while (j < len) {
      while (j < len && chars[j] == ' ') {
        j++;             // skip spaces
      }
      while (j < len && chars[j] != ' ') {
        chars[i++] = chars[j++]; // keep non spaces
      }
      while (j < len && chars[j] == ' ') {
        j++;             // skip spaces
      }
      if (j < len) {
        chars[i++] = ' ';    // keep only one space
      }
    }

    return new String(chars).substring(0, i);
  }

  // reverse a[] from a[i] to a[j]
  private void reverse(char[] chars, int i, int j) {
    while (i < j) {
      char t = chars[i];
      chars[i++] = chars[j];
      chars[j--] = t;
    }
  }
}
