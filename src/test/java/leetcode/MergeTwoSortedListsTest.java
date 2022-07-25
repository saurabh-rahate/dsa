package leetcode;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MergeTwoSortedListsTest {
    @Test
    public void test00() {
        ListNode list1 = ListNode.numberToList();
        ListNode list2 = ListNode.numberToList(4, 5, 6);

        ListNode result = MergeTwoSortedLists.mergeTwoLists(list1, list2);

        assertTrue(ListNode.areEqual(result, ListNode.numberToList(4, 5, 6)));
    }

    @Test
    public void test01() {
        ListNode list1 = ListNode.numberToList(1, 2, 3);
        ListNode list2 = ListNode.numberToList();

        ListNode result = MergeTwoSortedLists.mergeTwoLists(list1, list2);

        assertTrue(ListNode.areEqual(result, ListNode.numberToList(1, 2, 3)));
    }

    @Test
    public void test03() {
        ListNode list1 = ListNode.numberToList();
        ListNode list2 = ListNode.numberToList();

        ListNode result = MergeTwoSortedLists.mergeTwoLists(list1, list2);

        assertTrue(ListNode.areEqual(result, null));
    }

    @Test
    public void test1() {
        ListNode list1 = ListNode.numberToList(1, 2, 3);
        ListNode list2 = ListNode.numberToList(4, 5, 6);

        ListNode result = MergeTwoSortedLists.mergeTwoLists(list1, list2);

        assertTrue(ListNode.areEqual(result, ListNode.numberToList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void test2() {
        ListNode list1 = ListNode.numberToList(1, 2, 3);
        ListNode list2 = ListNode.numberToList(1, 2, 3);

        ListNode result = MergeTwoSortedLists.mergeTwoLists(list1, list2);

        assertTrue(ListNode.areEqual(result, ListNode.numberToList(1, 1, 2, 2, 3, 3)));
    }

    @Test
    public void test3() {
        ListNode list1 = ListNode.numberToList(1, 2, 4);
        ListNode list2 = ListNode.numberToList(1, 3, 4);

        ListNode result = MergeTwoSortedLists.mergeTwoLists(list1, list2);

        assertTrue(ListNode.areEqual(result, ListNode.numberToList(1, 1, 2, 3, 4, 4)));
    }

}
