package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RemoveDuplicatesFromSortedList2Test {

    @Test
    public void test0() {
        ListNode list = ListNode.numberToList();

        ListNode result = RemoveDuplicatesFromSortedList2.deleteDuplicates(list);

        assertTrue(ListNode.areEqual(result, ListNode.numberToList()));
    }

    @Test
    public void test1() {
        ListNode list = ListNode.numberToList(1);

        ListNode result = RemoveDuplicatesFromSortedList2.deleteDuplicates(list);

        assertTrue(ListNode.areEqual(result, ListNode.numberToList(1)));
    }

    @Test
    public void test2() {
        ListNode list = ListNode.numberToList(1, 1);

        ListNode result = RemoveDuplicatesFromSortedList2.deleteDuplicates(list);

        assertTrue(ListNode.areEqual(result, ListNode.numberToList()));
    }

    @Test
    public void test3() {
        ListNode list = ListNode.numberToList(1, 2);

        ListNode result = RemoveDuplicatesFromSortedList2.deleteDuplicates(list);

        assertTrue(ListNode.areEqual(result, ListNode.numberToList(1, 2)));
    }

    @Test
    public void test4() {
        ListNode list = ListNode.numberToList(1, 1, 1, 2, 3);

        ListNode result = RemoveDuplicatesFromSortedList2.deleteDuplicates(list);

        assertTrue(ListNode.areEqual(result, ListNode.numberToList(2, 3)));
    }

    @Test
    public void test5() {
        ListNode list = ListNode.numberToList(1, 1, 1, 1, 1);

        ListNode result = RemoveDuplicatesFromSortedList2.deleteDuplicates(list);

        assertTrue(ListNode.areEqual(result, ListNode.numberToList()));
    }

    @Test
    public void test6() {
        ListNode list = ListNode.numberToList(1, 2, 3, 3, 4, 4, 5);

        ListNode result = RemoveDuplicatesFromSortedList2.deleteDuplicates(list);

        assertTrue(ListNode.areEqual(result, ListNode.numberToList(1, 2, 5)));
    }
}
