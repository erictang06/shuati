package shuati.Tree;

import shuati.data.structure.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class TreeTraversal {
  /**
   * Iterative in-order traversal
   */
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();

    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;

    while(cur!=null || !stack.empty()){
      while(cur!=null){
        stack.add(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      list.add(cur.val);
      cur = cur.right;
    }

    return list;
  }

  /**
   * Traversal by Level
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> lists = new ArrayList<>();
    if (root == null) {
      return lists;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int numInLevel = queue.size();
      List<Integer> list = new ArrayList<>();
      for (int i=0; i<numInLevel; i++) {
        if (queue.peek().left != null) {
          queue.offer(queue.peek().left);
        }
        if (queue.peek().right != null) {
          queue.offer(queue.peek().right);
        }
        list.add(queue.poll().val);
      }
      lists.add(list);
    }

    return lists;
  }
}
