package shuati.Tree;

import shuati.data.structure.TreeNode;


public class InvertTree {
  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   *     int val;
   *     TreeNode left;
   *     TreeNode right;
   *     TreeNode(int x) { val = x; }
   * }
   */

    public TreeNode invertTree(TreeNode root) {
      if (root == null) {
        return null;
      }

      TreeNode left = root.left;
      TreeNode right = root.right;
      root.left = invertTree(right);
      root.right = invertTree(left);
      return root;
    }
  }
