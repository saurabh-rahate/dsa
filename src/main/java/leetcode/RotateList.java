package leetcode;

public class RotateList {
    public static void main(String[] args) {
        RotateList a = new RotateList();
        a.rotateRight(ListNode.numberToList(1, 2, 3, 4, 5), 2);
    }

    private static int length;

    public ListNode rotateRight(ListNode head, int k) {
        length = countNodes(head);
        if (length == 0 || length == 1)
            return head;
        k = k >= length ? k % length : k;
        if (k == 0)
            return head;
        else {
            k = length - k;
            ListNode current = head;
            for (int i = 1; i < k; i++) {
                current = current.next;
            }
            ListNode next = current.next;
            current.next = null;

            ListNode newHead = next;
            while (next.next != null) {
                next = next.next;
            }
            next.next = head;
            head = newHead;
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
