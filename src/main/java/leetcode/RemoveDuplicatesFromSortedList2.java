package leetcode;

// 82. Remove Duplicates from Sorted List II
// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
public class RemoveDuplicatesFromSortedList2 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head;

        int valToRemove = Integer.MIN_VALUE;

        while (current!=null) {
            if(current.val == current.next.val) {
                valToRemove = current.val;

                while (current != null && current.val != valToRemove) {
                    current = current.next;
                }

            }
            if(current == head) {

            }
        }
//        if (head.next.next == null)
//            if (head.val == head.next.val) return null;
//            else return head;
//
//        ListNode prev = head;
//        ListNode current = head.next;
//        while (current != null && prev.val == current.val) {
//            prev = prev.next;
//            current = current.next;
//            head = current;
//        }
//        prev = head;
//        current = head.next;
//        ListNode next = current.next;


//        while(true) {
//            if(current.val == next.val) {
////                next
//                while (next.val != current.val) {
//                    next = next.next;
//                }
//            } else {
//                prev = prev.next;
//                current = current.next;
//                next = next.next;
//            }
//        }

        return head;
    }
}
