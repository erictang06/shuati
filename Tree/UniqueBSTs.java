package shuati.Tree;

import shuati.data.structure.TreeNode;
import java.util.ArrayList;
import java.util.List;


/**
 *
 Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

 Example:

 Input: 3
 Output: 5
 Explanation:
 Given n = 3, there are a total of 5 unique BST's:

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 */
public class UniqueBSTs {
  public int numTrees(int n) {
    int[] fn = new int[n + 1];

    fn[0] = 1;
    fn[1] = 1;

    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        fn[i] += fn[j - 1] * fn[i - j];
      }
    }

    return fn[n];
  }

  // TODO: need to figure out how to implement the generation of these unique BST
  public List<TreeNode> generateTrees(int n) {

    return genTrees(1, n);
  }

  public List<TreeNode> genTrees(int start, int end) {

    List<TreeNode> list = new ArrayList<TreeNode>();

    if (start > end) {
      list.add(null);
      return list;
    }

    if (start == end) {
      list.add(new TreeNode(start));
      return list;
    }

    List<TreeNode> left, right;
    for (int i = start; i <= end; i++) {

      left = genTrees(start, i - 1);
      right = genTrees(i + 1, end);

      for (TreeNode lnode : left) {
        for (TreeNode rnode : right) {
          TreeNode root = new TreeNode(i);
          root.left = lnode;
          root.right = rnode;
          list.add(root);
        }
      }
    }

    return list;
  }
}
