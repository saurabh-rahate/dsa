package leetcode.range200_300;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsomorphicStringsTest {

    IsomorphicStrings subject = new IsomorphicStrings();

    @Test
    void test1() {
        assertFalse(subject.isIsomorphic("bbbaaaba", "aaabbbba"));
    }

    @Test
    void test2() {
        assertFalse(subject.isIsomorphic("badc", "baba"));
    }

    @Test
    void test3() {
        assertTrue(subject.isIsomorphic("egg", "add"));
    }

    @Test
    void test4() {
        assertFalse(subject.isIsomorphic("foo", "bar"));
    }

    @Test
    void test5() {
        assertTrue(subject.isIsomorphic("paper", "title"));
    }
}