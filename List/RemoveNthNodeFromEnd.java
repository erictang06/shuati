package shuati.List;

import shuati.data.structure.ListNode;


/**
 *
 Given a linked list, remove the n-th node from the end of list and return its head.

 Example:

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:

 Given n will always be valid.
 */
public class RemoveNthNodeFromEnd {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null || n < 0) {
      return head;
    }

    ListNode start = new ListNode(0);
    ListNode fast = start;
    ListNode slow = start;
    slow.next = head;

    for (int i = 0; i <= n; i++) {
      fast = fast.next;
    }
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return start.next;
  }
}
