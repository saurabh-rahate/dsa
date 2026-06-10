package leetcode.range100_200;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {
    public static void main(String[] args) {
        reorderList(ListNode.numberToList(1, 2, 3, 4, 5));
    }

    public static void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode i = head;
        while (i != null) {
            list.add(i);
            i = i.next;
        }

        int last = list.size() - 1;
        int mid = last / 2;
        int first = 0;
        while (mid-- > 0) {
            list.get(first).next = list.get(last);
            list.get(last - 1).next = null;
            list.get(last).next = list.get(first + 1);
//            System.out.println(head);
            first++;
            last--;
        }
    }
}
