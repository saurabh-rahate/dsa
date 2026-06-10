package leetcode.range1600_1700;

import leetcode.ListNode;

public class MergeInBetweenLinkedLists {
    public static void main(String[] args) {
        System.out.println(mergeInBetween(ListNode.numberToList(10, 1, 13, 6, 9, 5), 3, 4, ListNode.numberToList(1000000, 1000001, 1000002)));
        System.out.println(mergeInBetween(ListNode.numberToList(0, 1, 2, 3, 4, 5, 6), 2, 5, ListNode.numberToList(1000000, 1000001, 1000002, 1000003, 1000004)));
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        ListNode start = null, end = null;
        for (int i = 0; head != null || end == null; i++) {
            if (i == a - 1) start = head;
            head = head.next;
            if (i == b) end = head;
        }
        start.next = list2;

        head = list2;
        while (head != null && head.next != null) {
            head = head.next;
        }
        head.next = end;

        return list1;
    }
}
