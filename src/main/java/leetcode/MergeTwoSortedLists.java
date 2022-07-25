package leetcode;

public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val <= list2.val)
            return sortedList(list1, list2);
        return sortedList(list2, list1);
    }

    private static ListNode sortedList(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(list1.val);
        list1 = list1.next;
        ListNode current = head;

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                current.next = new ListNode(list2.val);
                list2 = list2.next;
            } else if (list2 == null) {
                current.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                if (list1.val <= list2.val) {
                    current.next = new ListNode(list1.val);
                    list1 = list1.next;
                } else {
                    current.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
            }
            current = current.next;
        }
        return head;
    }
}
