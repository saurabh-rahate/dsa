package leetcode;

public class SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        if(head != null && head.next != null) {
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = head;
            head = temp;
        } else {
            return head;
        }
        ListNode prev = head.next;
        while (prev.next != null && prev.next.next!= null) {
            ListNode node1 = prev.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            node1.next = next;
            node2.next = node1;
            prev.next = node2;

            prev = node1;

        }
        return head;
    }
}
