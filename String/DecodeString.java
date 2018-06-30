package shuati.String;

/**
 * Given an encoded string, return it's decoded string.

   The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
   Note that k is guaranteed to be a positive integer.

   You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

   Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers,
   k. For example, there won't be input like 3a or 2[4].

   Examples:
   s = "3[a]2[bc]", return "aaabcbc".
   s = "3[a2[c]]", return "accaccacc".
   s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */

public class DecodeString {
  public String decodeString(String s) {

    return reduce(s);
  }

  /**
   * eliminate the first inner most []
   * algorithm is,
   *   - scan string from left to right, upon seeing the first ']', log its index_1,
   *   - now looks for the last index of '[', log its index_2
   *   - next looks for the number immediately infront of '['
   *   - then expand the string to s_sub
   *   - now we reconstruct the string with three part: s.substring(0, index_2) + s_sub + s.substring(idex_1)
   *   - recusion on the above steps
   * @param s
   * @return
   */
  private String reduce(String s) {
    int index_1 = s.indexOf("]");
    if (index_1 == -1) {
      return s;
    }

    String remaining = s.substring(index_1 + 1);
    String first_part = s.substring(0, index_1);
    int index_2 = s.lastIndexOf("[");
    String repeatedString = s.substring(index_2+1, index_1);
    // next need to find the number to be repeated
    int indexDigit = index_2-1;
    while (s.charAt(indexDigit) >= '0' && s.charAt(indexDigit) <= '9') {
      indexDigit--;
    }
    int repeatedNumber = Integer.parseInt(s.substring(indexDigit, index_2-1));
    String sub = expand(repeatedString, repeatedNumber);

    return reduce(remaining + sub + first_part);
  }

  /**
   * expand a string s k times, for example, expand("ab", 5) would produce "ababababab"
   * @param s
   * @param k
   * @return
   */
  private String expand(String s, Integer k) {
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<k; i++) {
      sb.append(s);
    }

    return  sb.toString();
  }
}
