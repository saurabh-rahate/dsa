package leetcode;

// 83. Remove Duplicates from Sorted List
// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode prev = head;
        ListNode current = head.next;

        while(current != null) {
            if(prev.val == current.val) {
                current = current.next;
                prev.next = current;
            } else {
                prev = prev.next;
                current = current.next;
            }
        }
        return head;
    }
}
