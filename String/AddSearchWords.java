package shuati.String;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Design a data structure that supports the following two operations:
 *   void addWord(word)
 *   bool search(word)
 *   search(word) can search a literal word or a regular expression string containing only letters a-z or ..
 *   A . means it can represent any one letter.
 */

/**
 * Classic TRIE application -- other than the search for regex search
 */

public class AddSearchWords {
  public class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public String item = "";
  }

  private TrieNode root = new TrieNode();

  public void addWord(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      if (node.children[c - 'a'] == null) {
        node.children[c - 'a'] = new TrieNode();
      }
      node = node.children[c - 'a'];
    }
    node.item = word;
  }

  public boolean search(String word) {
    return match(word.toCharArray(), 0, root);
  }

  private boolean match(char[] chs, int k, TrieNode node) {
    if (k == chs.length) {
      return !node.item.equals("");
    }
    if (chs[k] != '.') {
      return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
    } else {
      for (int i = 0; i < node.children.length; i++) {
        if (node.children[i] != null) {
          if (match(chs, k + 1, node.children[i])) {
            return true;
          }
        }
      }
    }
    return false;
  }
}

class AddSearchWords2 {

  Set<String> dictSet;

  /** Initialize your data structure here. */
  public AddSearchWords2() {
    dictSet = new HashSet<>();
  }

  /** Adds a word into the data structure. */
  public void addWord(String word) {
    dictSet.add(word);
  }

  /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
  public boolean search(String word) {
    Pattern pattern = Pattern.compile(word);
    Iterator iterator = dictSet.iterator();
    while (iterator.hasNext()) {
      if (pattern.matcher((String) (iterator.next())).find() == true) {
        return true;
      }
    }

    return false;
  }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
