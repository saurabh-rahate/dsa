package leetcode.range400_500;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NonDecreasingSubsequencesTest {

    NonDecreasingSubsequences subject = new NonDecreasingSubsequences();

    @Test
    public void test1() {
        List<List<Integer>> result = subject.findSubsequences(new int[]{4, 6, 7, 7});

        assertEquals(8, result.size());
        assertTrue(result.contains(List.of(4, 6)));
        assertTrue(result.contains(List.of(4, 6, 7)));
        assertTrue(result.contains(List.of(4, 6, 7, 7)));
        assertTrue(result.contains(List.of(4, 7)));
        assertTrue(result.contains(List.of(4, 7, 7)));
        assertTrue(result.contains(List.of(6, 7)));
        assertTrue(result.contains(List.of(6, 7, 7)));
        assertTrue(result.contains(List.of(7, 7)));
    }

    @Test
    public void test2() {
        List<List<Integer>> result = subject.findSubsequences(new int[]{4, 4, 3, 2, 1});

        assertEquals(1, result.size());
        assertTrue(result.contains(List.of(4, 4)));
    }

    @Test
    public void test3() {
        List<List<Integer>> result = subject.findSubsequences(new int[]{4, 6, 7, 3, 5});

        assertEquals(5, result.size());
        assertTrue(result.contains(List.of(4, 6)));
        assertTrue(result.contains(List.of(4, 6, 7)));
        assertTrue(result.contains(List.of(6, 7)));
        assertTrue(result.contains(List.of(3, 5)));
        assertTrue(result.contains(List.of(4, 5)));
    }
}