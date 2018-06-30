package shuati.Tree;

import shuati.data.structure.TreeNode;


/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.

 For example, given

 preorder = [3,9,20,15,7]
 inorder = [9,3,15,20,7]
 Return the following binary tree:

 3
 / \
 9  20
 /  \
 15   7
 */
public class RebuildTreeFromPreInorderTraversal {

  /*
  Say we have 2 arrays, PRE and IN.
Preorder traversing implies that PRE[0] is the root node.
Then we can find this PRE[0] in IN, say it's IN[5].
Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
Recursively doing this on subarrays, we can build a tree out of it :)
   */
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return buildSubTree(preorder, inorder, 0, 0, inorder.length - 1);
  }

  private TreeNode buildSubTree(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
    if (preStart > preorder.length || inStart > inEnd) {
      return null;
    }

    TreeNode root = new TreeNode(preorder[preStart]);
    // find index of preStart in inorder
    int index = 0;
    while (preorder[preStart] != inorder[index]) {
      index++;
    }
    root.left = buildSubTree(preorder, inorder, preStart+1, inStart, index-1);
    root.right = buildSubTree(preorder, inorder, preStart+index-inStart+1, index+1, inEnd);
    return root;
  }
}
