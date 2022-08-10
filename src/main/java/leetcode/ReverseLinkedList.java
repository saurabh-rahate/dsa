package leetcode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        return reverse(head);
    }

    private static ListNode reverse(ListNode head) {
        if (head != null && head.next != null) {
            ListNode newHead = reverse(head.next);
            ListNode oldHeadNext = head.next;
            head.next = null;
            oldHeadNext.next = head;
            head = newHead;
        }
        return head;
    }

}
