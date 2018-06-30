package shuati.String;

import java.util.ArrayList;
import java.util.List;


/**
 *
   Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters
   and is fully (left and right) justified.

   You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
   Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

   Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not
   divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

   For the last line of text, it should be left justified and no extra space is inserted between words.

   Note:

   A word is defined as a character sequence consisting of non-space characters only.
   Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
   The input array words contains at least one word.
 */
public class TextJustification {
  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> res = new ArrayList();
    for (int indexWords = 0, indexInLine; indexWords < words.length; indexWords = indexInLine) {
      // indexWords: the index of word
      // indexInLine: the current index of words in the line
      // curLen: current total len of words in the line
      // We need to skip the space for last word hence start len = -1
      // check how many words fit into the line
      int curLen = -1;
      for (indexInLine = indexWords; indexInLine < words.length && curLen + words[indexInLine].length() + 1 <= maxWidth;
          indexInLine++) {
        curLen += words[indexInLine].length() + 1;
      }
      StringBuilder curStr = new StringBuilder(words[indexWords]);
      int space = 1, extra = 0;
      // not one word, not last line
      if (indexInLine != indexWords + 1 && indexInLine != words.length) {
        space = (maxWidth - curLen) / (indexInLine - indexWords - 1) + 1; // 1 is for another space
        extra = (maxWidth - curLen) % (indexInLine - indexWords - 1);
      }
      // not one word, including last line, initialize space == 1 is to deal with last line case.
      for (int j = indexWords + 1; j < indexInLine; j++) { // j: index of word in the current line
        for (int s = space; s > 0; s--) {
          curStr.append(" "); // add the "even" space
        }
        if (extra-- > 0) {
          curStr.append(" ");
        }
        curStr.append(words[j]);
      }

      //Handle the above two cases we skipped, where there is only one word on line
      //or we reached end of word array. Last line should remain left aligned.
      int remaining = maxWidth - curStr.length();
      while (remaining-- > 0) {
        curStr.append(" ");
      }
      res.add(curStr.toString());
    }

    return res;
  }
}
