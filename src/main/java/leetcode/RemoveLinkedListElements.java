package leetcode;

public class RemoveLinkedListElements {
    public static void main(String[] args) {

        System.out.println(removeElements(ListNode.numberToList(1, 2, 6, 3, 4, 5, 6), 6));
        System.out.println(removeElements(ListNode.numberToList(), 6));
    }

    public static ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null || head.next == null) return head;
        removeValue(head, val);
        return head;
    }

    private static void removeValue(ListNode node, int val) {
        ListNode nextNode = node.next;
        if (nextNode != null)
            if (nextNode.val == val) {
                node.next = nextNode.next;
                removeValue(node, val);
            } else {
                node = nextNode;
                removeValue(node, val);
            }
    }
}
