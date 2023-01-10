package leetcode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        System.out.println(reverse(ListNode.numberToList(1,2,3,4,5)));
        System.out.println(reverse2(ListNode.numberToList(1,2,3,4,5)));
    }

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

    private static ListNode reverse2(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode prevNode = null;
        ListNode currentNode = head;
        ListNode nextNode = head.next;

        while (nextNode != null) {
            currentNode.next = prevNode;

            prevNode = currentNode;
            currentNode = nextNode;
            nextNode = nextNode.next;
        }
        currentNode.next = prevNode;

        return currentNode;
    }

}
