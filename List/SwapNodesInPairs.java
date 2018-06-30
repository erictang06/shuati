package shuati.List;

import shuati.data.structure.ListNode;


/**
 * Given a linked list, swap every two adjacent nodes and return its head.

 Example:

 Given 1->2->3->4, you should return the list as 2->1->4->3.
 Note:

 Your algorithm should use only constant extra space.
 You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class SwapNodesInPairs {
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode nNode = head.next;
    nNode.next = swapPairs(head.next.next);
    head.next = nNode.next;
    nNode.next = head;
    return nNode;
  }
}
