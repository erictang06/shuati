package shuati.String;

/**
 *
   The count-and-say sequence is the sequence of integers with the first five terms as following:

   1.     1
   2.     11
   3.     21
   4.     1211
   5.     111221
   1 is read off as "one 1" or 11.
   11 is read off as "two 1s" or 21.
   21 is read off as "one 2, then one 1" or 1211.
    Given an integer n, generate the nth term of the count-and-say sequence.
 */

public class CoundAndSay {

  public String countAndSay(int n) {
    String s = "1";
    for (int i = 1; i < n; i++) {
      s = helper(s);
    }
    return s;
  }

  private String helper(String numString) {
    String resultStr = "";
    int i = 0;
    while (i < numString.length()) {
      int j = 0;
      while (i + j < numString.length() && numString.charAt(i + j) == numString.charAt(i)) {
        j++;
      }
      resultStr += String.valueOf(j) + numString.charAt(i);
      i += j;
    }
    return resultStr;
  }
}
