package leetcode.range0_100;

import leetcode.ListNode;

public class RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {
        System.out.println(deleteDuplicates(ListNode.numberToList(1,2,3,3,4,4,5)));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode current = head;
        ListNode next = head.next;

        while (next != null) {
            if (current.val == next.val) {
                while (next != null && next.val != current.val) {
                    next = next.next;
                }
            }
            if (prev != null) {
                prev.next = current;
            } else {
                head = current;
            }
            current = next;
            next = next != null ? next.next : next;
        }
        return head;
    }
}
