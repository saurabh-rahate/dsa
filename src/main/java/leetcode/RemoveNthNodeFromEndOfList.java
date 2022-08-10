package leetcode;

public class RemoveNthNodeFromEndOfList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = countNodes(head);
        int nodeToRemove = length - n + 1;
        if (nodeToRemove == 1)
            return head.next;
        else {
            ListNode current = head;
            for (int i = 1; i < nodeToRemove - 1; i++) {
                current = current.next;
            }
            ListNode deletedNode = current.next;
            current.next = deletedNode.next;
        }
        return head;
    }

    private static int countNodes(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

}
