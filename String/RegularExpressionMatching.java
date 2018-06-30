package shuati.String;

/*

 */

public class RegularExpressionMatching {

  /**
   * dp[i][j]: if s[0...i-1] matches p[0...j-1]
   *
   * 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
   * 2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
   * 3, If p.charAt(j) == '*':
   *     here are two sub conditions:
   *     1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
   *     2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
   *            dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
   *            or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
   *            or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
   * @param s
   * @param p
   * @return
   */
  public boolean isMatch(String s, String p) {

    if (s == null || p == null) {
      return false;
    }
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;
    for (int i = 0; i < p.length(); i++) {
      if (p.charAt(i) == '*' && dp[0][i - 1]) {
        dp[0][i + 1] = true;
      }
    }
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < p.length(); j++) {
        if (p.charAt(j) == '.') {
          dp[i + 1][j + 1] = dp[i][j];
        }
        if (p.charAt(j) == s.charAt(i)) {
          dp[i + 1][j + 1] = dp[i][j];
        }
        if (p.charAt(j) == '*') {
          if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
            dp[i + 1][j + 1] = dp[i + 1][j - 1];
          } else {
            dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
          }
        }
      }
    }
    return dp[s.length()][p.length()];
  }

  public boolean isMatch2(String s, String p) {
    if (s == null || p == null) {
      return s == p;
    }
    int[][] dp = new int[s.length() + 1][p.length() + 1];
    dp[0][0] = 1;

    for (int col = 1; col < dp[0].length; col++) {
      if (p.charAt(col - 1) == '*') {
        dp[0][col] = dp[0][col - 2];
      }
    }

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
          dp[i][j] = dp[i - 1][j - 1]; //if chars are same or if chars do not match and there is '.' .
        } else if (p.charAt(j - 1) == '*') {
          dp[i][j] =
              dp[i][j - 2] == 1 ? 1 : (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.' ? dp[i - 1][j] : 0);
        }
      }
    }
    return dp[s.length()][p.length()] == 1;
  }
}
