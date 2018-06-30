package shuati.String;

/**
 *
 Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 Example:

 Input: S = "ADOBECODEBANC", T = "ABC"
 Output: "BANC"
 Note:

 If there is no such window in S that covers all characters in T, return the empty string "".
 If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {

  // https://aaronice.gitbooks.io/lintcode/content/two_pointers/minimum_window_substring.html
  /*
  可以用窗口型两个指针的思路来解决，外层for循环i = 0 ... n, 内层while循环，条件是j < source.length() 和 !isValid(sourceHash, targetHash)，
  前者是数组下标边界，后者是一个函数，检查当前窗口中的substring是否包含了目标字符串中全部所需的字符，未满足则继续扩大窗口j++，同时更新sourceHash。
  这里sourceHash，targetHash是整型数组int[]，因为ASCII码最多256个，因此用int[]可以作为简化的HashMap使用，key是char对应的int的值，
  value则是该char在substring中的出现个数。isValid函数则检查sourceHash是否全部包含了targetHash，256个字符一一对应，因此只需一重for循环，
  如果sourceHash[i] < targetHash[i]，则说明有字符未满足条件。
  需要注意的是，要设定一个辅助变量记录minStr的长度。
   */

  public String minWindow(String source, String target) {
    if (source == null || target == null || source.length() == 0 || target.length() == 0) {
      return "";
    }

    int[] sourceHash = new int[256];
    int[] targetHash = new int[256];

    initializeTHash(targetHash, target);
    int minLen = Integer.MAX_VALUE;
    String subs = "";

    int j = 0;

    for (int i = 0; i < source.length(); i++) {
      while (j < source.length() && !sourceContainsTarget(sourceHash, targetHash)) {
        sourceHash[source.charAt(j)]++;

        if (j < source.length()) {
          j++;
        } else {
          break;
        }
      }
      if (sourceContainsTarget(sourceHash, targetHash)) {
        if (minLen > j - i) {
          minLen = j - i;
          subs = source.substring(i, j);
        }
      }
      sourceHash[source.charAt(i)]--;
    }

    return subs;
  }

  private boolean sourceContainsTarget(int[] sourceHash, int[] targetHash) {
    for (int i = 0; i < targetHash.length; i++) {
      if (sourceHash[i] < targetHash[i]) {
        return false;
      }
    }

    return true;
  }

  private void initializeTHash(int[] thash, String t) {
    for (char c : t.toCharArray()) {
      thash[c]++;
    }
  }
}
