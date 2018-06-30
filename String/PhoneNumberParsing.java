package shuati.String;

import java.util.ArrayList;
import java.util.List;


public class PhoneNumberParsing {


  private void dfs(List<String> results, String phone[], String digits, String curString, int index, int length) {
    if (index == length) {
      results.add(curString);
      return;
    }
    int d = digits.charAt(index) - '0';
    for (char c : phone[d].toCharArray()) {
      dfs(results, phone, digits,curString + c, index + 1, length);
    }
  }

  public List<String> letterCombinations(String digits) {
    // write your code here
    String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    List<String> results = new ArrayList<>();
    if (digits.length() == 0) {
      return results;
    }

    dfs(results, phone, digits, "", 0, digits.length());
    return results;
  }
}
