package shuati.Tree;

/**
 * Implement a trie with insert, search, and startsWith methods.

 Example:

 Trie trie = new Trie();

 trie.insert("apple");
 trie.search("apple");   // returns true
 trie.search("app");     // returns false
 trie.startsWith("app"); // returns true
 trie.insert("app");
 trie.search("app");     // returns true

 */
public class Trie {

  public final int ALPHABET_SIZE = 26;

  private TrieNode root;

  public Trie() {
    root = new TrieNode();
    root.val = ' ';
  }

  public void insert(String word) {
    TrieNode ws = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (ws.children[c - 'a'] == null) {
        ws.children[c - 'a'] = new TrieNode(c);
      }
      ws = ws.children[c - 'a'];
    }
    ws.isWord = true;
  }

  public boolean search(String word) {
    TrieNode ws = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (ws.children[c - 'a'] == null) {
        return false;
      }
      ws = ws.children[c - 'a'];
    }
    return ws.isWord;
  }

  public boolean startsWith(String prefix) {
    TrieNode ws = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (ws.children[c - 'a'] == null) {
        return false;
      }
      ws = ws.children[c - 'a'];
    }
    return true;
  }

  // Peform a walk on the trie and return the
  // longest common prefix string
  public String walkTrie() {
    TrieNode pCrawl = root;
    int indexs = 0;
    String prefix = "";

    while (countChildren(pCrawl) == 1 && pCrawl.isWord == false) {
      pCrawl = pCrawl.children[indexs];
      prefix += (char) ('a' + indexs);
    }
    return prefix;
  }

  // A Function to construct trie
  private void constructTrie(String arr[], int n) {
    for (int i = 0; i < n; i++) {
      insert(arr[i]);
    }
    return;
  }

  // Counts and returns the number of children of the current node
  private int countChildren(TrieNode node) {
    int count = 0;
    for (int i = 0; i < ALPHABET_SIZE; i++) {
      if (node.children[i] != null) {
        count++;
//        indexs = i;
      }
    }
    return (count);
  }

  // A Function that returns the longest common prefix
  // from the array of strings
  private String commonPrefix(String arr[], int n) {
    TrieNode root = new TrieNode();
    constructTrie(arr, n);

    // Perform a walk on the trie
    return walkTrie();
  }
}

class TrieNode {
  public char val;
  public boolean isWord;
  public TrieNode[] children = new TrieNode[26];

  public TrieNode() {
  }

  TrieNode(char c) {
    TrieNode node = new TrieNode();
    node.val = c;
  }
}
