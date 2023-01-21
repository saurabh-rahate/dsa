package leetcode.range900_1000;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumSumCircularSubarrayTest {

    MaximumSumCircularSubarray subject = new MaximumSumCircularSubarray();

    @Test
    void test1() {
        assertEquals(3, subject.maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        assertEquals(10, subject.maxSubarraySumCircular(new int[]{5, -3, 5}));
        assertEquals(-2, subject.maxSubarraySumCircular(new int[]{-3, -2, -3}));
        assertEquals(4, subject.maxSubarraySumCircular(new int[]{3, -1, 2, -1}));
    }

}