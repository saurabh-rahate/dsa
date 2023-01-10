package leetcode;

// 83. Remove Duplicates from Sorted List
// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        System.out.println(deleteDuplicates2(ListNode.numberToList(1, 1, 2, 3, 3)));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = head;
        ListNode current = head.next;

        while (current != null) {
            if (prev.val == current.val) {
                current = current.next;
                prev.next = current;
            } else {
                prev = prev.next;
                current = current.next;
            }
        }
        return head;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode currentNode = head;
        ListNode nextNode = head.next;

        while (nextNode != null) {
            if (currentNode.val == nextNode.val) {
                nextNode = nextNode.next;
                currentNode.next = nextNode;
            } else {
                currentNode = nextNode;
                nextNode = nextNode.next;
            }
        }
        return head;
    }
}
