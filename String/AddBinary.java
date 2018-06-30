package shuati.String;

/**
 * Given two binary strings, return their sum (also a binary string).

 The input strings are both non-empty and contains only characters 1 or 0.

 Example 1:

 Input: a = "11", b = "1"
 Output: "100"
 Example 2:

 Input: a = "1010", b = "1011"
 Output: "10101"
 */
public class AddBinary {
  public String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int i, j;
    int carry = 0;
    for (i=a.length()-1, j=b.length()-1; i>=0 || j>=0 || carry == 1; i--, j--) {
      int a1 = (i>=0) ? a.charAt(i) - '0' : 0;
      int b1 = (j>=0) ? b.charAt(j) - '0' : 0;
      sb.insert(0, a1^b1^carry);
      carry = (carry + a1 + b1 >= 2) ? 1 : 0;
    }

    return sb.toString();
  }
}
