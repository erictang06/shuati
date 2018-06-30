package shuati.String;

public class ValidPalendrome {
  /*
  Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
    Note: For the purpose of this problem, we define empty string as valid palindrome.
    Example 1:
    Input: "A man, a plan, a canal: Panama"
    Output: true
    Example 2:
    Input: "race a car"
    Output: false
   */

  public boolean isPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }

    int left = 0;
    int right = s.length() - 1;
    while (left <= right) {
      char cHead = s.charAt(left);
      char cTail = s.charAt(right);
      if (!Character.isLetterOrDigit(cHead)) {
        left++;
      } else if (!Character.isLetterOrDigit(cTail)) {
        right--;
      } else {
        if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
          return false;
        }
        left++;
        right--;
      }
    }

    return true;
  }

  /*
  Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

    Example 1:
    Input: "aba"
    Output: True
    Example 2:
    Input: "abca"
    Output: True
    Explanation: You could delete the character 'c'.
   */
  public boolean validPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }

    int left = 0;
    int right = s.length() - 1;
    while (left <= right) {
      if (s.charAt(left) == s.charAt(right)) {
        left++;
        right--;
      } else {
        return isPal(s, left+1, right) || isPal(s, left, right-1);
      }
    }

    return true;
  }

  private boolean isPal(String s, int left, int right) {
    while (left <= right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
