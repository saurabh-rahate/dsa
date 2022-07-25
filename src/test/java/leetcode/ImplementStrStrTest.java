package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImplementStrStrTest {

    @Test
    public void test0() {
        assertEquals(0, ImplementStrStr.strStr("hello", ""));
    }

    @Test
    public void test1() {
        assertEquals(2, ImplementStrStr.strStr("hello", "ll"));
    }

    @Test
    public void test2() {
        assertEquals(-1, ImplementStrStr.strStr("aaaaa", "bba"));
    }

    @Test
    public void test3() {
        assertEquals(4, ImplementStrStr.strStr("mississippi", "issip"));
    }
}