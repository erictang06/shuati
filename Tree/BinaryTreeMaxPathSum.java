package shuati.Tree;

import shuati.data.structure.TreeNode;


/**
 * Given a non-empty binary tree, find the maximum path sum.
 For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along
 the parent-child connections. The path must contain at least one node and does not need to go through the root.

 Example 1:
 Input: [1,2,3]

 1
 / \
 2   3

 Output: 6
 */
public class BinaryTreeMaxPathSum {
  private int _maxSum;

  public int maxPathSum(TreeNode root) {
    _maxSum = Integer.MIN_VALUE;
    maxSubTree(root);
    return _maxSum;
  }

  private int maxSubTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int l = maxSubTree(root.left);
    int r = maxSubTree(root.right);
    int sum = root.val;
    if (l > 0) {
      sum += l;
    }
    if (r > 0) {
      sum += r;
    }
    _maxSum = Math.max(_maxSum, sum);
    return Math.max(r, l) > 0 ? Math.max(r, l) + root.val : root.val;
  }
}
