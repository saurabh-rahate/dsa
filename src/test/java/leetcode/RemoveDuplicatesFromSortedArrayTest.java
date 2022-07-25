package leetcode;

import org.junit.jupiter.api.Test;

class RemoveDuplicatesFromSortedArrayTest {
    @Test
    public void test0() {
        int[] nums = new int[] { 1 };
        int[] expectedNums = new int[] { 1 };

        test(nums, expectedNums);
    }

    @Test
    public void test1() {
        int[] nums = new int[] { 1, 2, 3, 3 };
        int[] expectedNums = new int[] { 1, 2, 3 };

        test(nums, expectedNums);
    }

    @Test
    public void test2() {
        int[] nums = new int[] { 1, 1, 2 };
        int[] expectedNums = new int[] { 1, 2 };

        test(nums, expectedNums);
    }

    @Test
    public void test3() {
        int[] nums = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int[] expectedNums = new int[] { 0, 1, 2, 3, 4 };

        test(nums, expectedNums);
    }

    private void test(int[] nums, int[] expectedNums) {
        int k = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);
        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }
}