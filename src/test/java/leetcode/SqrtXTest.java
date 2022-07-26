package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqrtXTest {

    @Test
    public void test0() {
        assertEquals(2, SqrtX.mySqrt(4));
    }

    @Test
    public void test1() {
        assertEquals(2, SqrtX.mySqrt(8));
    }

    @Test
    public void test2() {
        assertEquals(46340, SqrtX.mySqrt(2147483647));
    }

    @Test
    public void test3() {
        assertEquals(13553, SqrtX.mySqrt(183692038));
    }
}