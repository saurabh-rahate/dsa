package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInsertPositionTest {

    @Test
    public void test1() {
        assertEquals(2, SearchInsertPosition.searchInsert(new int[]{1, 3, 5, 6}, 5));
    }

    @Test
    public void test2() {
        assertEquals(1, SearchInsertPosition.searchInsert(new int[]{1, 3, 5, 6}, 2));
    }

    @Test
    public void test3() {
        assertEquals(4, SearchInsertPosition.searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
}