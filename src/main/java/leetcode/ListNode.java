package leetcode;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode numberToList(int... numbers) {
        if (numbers.length == 0)
            return null;
        ListNode head = new ListNode(numbers[0]);
        ListNode current = head;
        for (int i = 1; i < numbers.length; i++) {
            current.next = new ListNode(numbers[i]);
            current = current.next;
        }
        return head;
    }

    public static boolean areEqual(ListNode list1, ListNode list2) {
        while (list1 != null || list2 != null) {
            if (list1 == null || list2 == null || list1.val != list2.val)
                return false;
            list1 = list1.next;
            list2 = list2.next;
        }

        return true;
    }

    @Override
    public String toString() {
        String result = "";
        ListNode current = this;
        while (current != null) {
            result = result + current.val + "-";
            current = current.next;
        }
        return result;
    }

}
