package shuati.String;


/*
Design an algorithm to encode a list of strings to a string.
The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function:
vector<string> decode(string s) {
  //... your code
  return strs;
}
So Machine 1 does:

string encoded_string = encode(strs);
and Machine 2 does:

vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.

Note:
The string may contain any possible characters out of 256 valid ascii characters.
 Your algorithm should be generalized enough to work on any possible characters.
Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.


Tags: String
Similar Problems: (E) Count and Say, (M) Serialize and Deserialize Binary Tree

*/

import java.util.ArrayList;
import java.util.List;


public class EncodeDecodeStrings {

  public String encodeString(List<String> list) {
    StringBuffer sb = new StringBuffer();
    for (String str : list) {
      sb.append(str.length());
      sb.append("#");
      sb.append(str);
    }

    return sb.toString();
  }

  public List<String> decodeString(String s) {
    if (s == null || s.isEmpty()) {
      return null;
    }

    List<String> list = new ArrayList<>();
    int i = 0;
    while (i < s.length()) {
      int index = s.indexOf('#');
      int size = Integer.parseInt(s.substring(i, index));
      list.add(s.substring(index+1, index+1+size));
      i = index + size + 1;
    }

    return list;
  }

}
