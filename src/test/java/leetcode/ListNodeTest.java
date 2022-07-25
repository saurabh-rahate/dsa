package leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ListNodeTest {

    @Test
    public void test() {
        ListNode result = ListNode.numberToList(0, 1, 2, 3, 4);

        result.toString();
        for (int i = 0; i < 5; i++) {
            assertEquals(i, result.val);
            result = result.next;
        }
    }

    @Test
    public void testEqual() {
        ListNode list1 = ListNode.numberToList(1,2,3,4,5);
        ListNode list2 = ListNode.numberToList(1,2,3,4,5);

        assertTrue(ListNode.areEqual(list1, list2));
    }

    @Test
    public void testUnEqual() {
        ListNode list1 = ListNode.numberToList(1,2,3,4);
        ListNode list2 = ListNode.numberToList(1,2,5);

        assertFalse(ListNode.areEqual(list1, list2));
    }

}
