package shuati;

import java.util.ArrayList;
import java.util.List;


/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
   For example, given n = 3, a solution set is:
   [
   "((()))",
   "(()())",
   "(())()",
   "()(())",
   "()()()"
   ]
 */
public class GenerateParenthesis {
  public List<String> generateParenthesis(int n) {
    List<String> list = new ArrayList<>();
    helper(list, "", 0, 0, n);
    return list;
  }

  private void helper(List<String> list, String curString, int open, int close, int n) {
    if (curString.length() == n*2) {
      list.add(curString);
      return;
    }

    if (open < n) {
      helper(list, curString + '(', open+1, close, n);
    }
    if (open > close) {
      helper(list, curString + ')', open, close+1, n);
    }
  }
}
