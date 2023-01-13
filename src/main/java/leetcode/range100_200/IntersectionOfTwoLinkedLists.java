package leetcode.range100_200;

import leetcode.ListNode;

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = lengthOfList(headA);
        int l2 = lengthOfList(headB);

        return l1 >= l2 ? findIntersection(headA, l1, headB, l2) : findIntersection(headB, l2, headA, l1);
    }

    private ListNode findIntersection(ListNode list1, int l1, ListNode list2, int l2) {
        int diff = l1 - l2;
        while (diff-- > 0) {
            list1 = list1.next;
        }

        while (list1 != null && list2 != null && list1 != list2) {
            list1 = list1.next;
            list2 = list2.next;
        }

        if (list1 != null && list1 == list2) return list1;
        return null;
    }

    private int lengthOfList(ListNode list) {
        int length = 0;
        while (list != null) {
            length++;
            list = list.next;
        }
        return length;
    }
}
