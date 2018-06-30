package shuati.String;

import java.util.Stack;


/**
 *
   Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

   Example 1:

   Input: "(()"
   Output: 2
   Explanation: The longest valid parentheses substring is "()"
   Example 2:

   Input: ")()())"
   Output: 4
   Explanation: The longest valid parentheses substring is "()()"
 */
/*
    Scan the string from beginning to end.
    1) If current character is '(', push its index to the stack.
    2) If current character is ')':
       2.1 if the character at the index of the top of stack is '(',
           we just find a matching pair, so pop from the stack.
       2.2 Otherwise, we push the index of ')' to the stack.
    3) After the scan is done, the stack will only contain the indices of characters which cannot be matched.
    4) Then let's use the opposite side - substring between adjacent indices should be valid parentheses.
    5) If the stack is empty, the whole input string is valid.
    6) Otherwise, we can scan the stack to get longest valid substring as described in step 3.
 */

public class LongestValidParenthesis {
  public int longestValidParentheses(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(i);
      } else {
        if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
          stack.pop();
        } else {
          stack.push(i);
        }
      }
    }

    if (stack.isEmpty()) {
      return s.length();
    }

    int maxLen = 0;
    int index = s.length();
    while (!stack.isEmpty()) {
      int current = stack.pop();
      if (maxLen < index - current) {
        maxLen = index - current - 1;
      }
      index = current;
    }

    return maxLen > index ? maxLen : index;
  }
}