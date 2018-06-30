package shuati.List;

import shuati.data.structure.ListNode;


public class ReverseLinkedList {
  public ListNode reverseListIterative(ListNode head) {
    /* iterative solution */
    ListNode newHead = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = newHead;
      newHead = head;
      head = next;
    }
    return newHead;
  }

  public ListNode reverseListRecursive(ListNode head) {
    /* recursive solution */
    return reverseListInt(head, null);
  }

  private ListNode reverseListInt(ListNode head, ListNode newHead) {
    if (head == null)
      return newHead;
    ListNode next = head.next;
    head.next = newHead;
    return reverseListInt(next, head);
  }
}
