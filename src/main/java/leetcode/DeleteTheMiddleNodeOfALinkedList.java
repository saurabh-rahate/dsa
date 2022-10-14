package leetcode;

public class DeleteTheMiddleNodeOfALinkedList {
    public static ListNode deleteMiddle(ListNode head) {

        ListNode current = head;
        int length = 0;
        while (current != null) {
            current = current.next;
            length++;
        }
        current = head;
        for (int i = 0; i < length/2-1; i++) {
            current = current.next;
        }

        System.out.println(current.val);
        current.next = current.next.next;

        return head;
    }
}
