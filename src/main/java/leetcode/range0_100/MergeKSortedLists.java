package leetcode.range0_100;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeKSortedLists {
    public static void main(String[] args) {
        MergeKSortedLists obj = new MergeKSortedLists();
        System.out.println(obj.mergeKLists(new ListNode[]{
                ListNode.numberToList(1, 4, 5),
                ListNode.numberToList(1, 3, 4),
                ListNode.numberToList(2, 6)
        }));
    }

    private static List<ListNode> numberList;

    public ListNode mergeKLists(ListNode[] lists) {
        numberList = new ArrayList<>();

        for (ListNode node : lists) {
            addNumbersToList(node);
        }

        numberList.sort(Comparator.comparingInt(o -> o.val));

        for (int i = 0; i < numberList.size() - 1; i++) {
            numberList.get(i).next = numberList.get(i + 1);
        }

        return numberList.size() == 0 ? null : numberList.get(0);
    }

    private void addNumbersToList(ListNode node) {
        if (node != null) {
            numberList.add(node);
            addNumbersToList(node.next);
        }
    }
}
