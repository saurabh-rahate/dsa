package leetcode;

import org.junit.jupiter.api.Test;

class RemoveElementTest {
    @Test
    public void test0() {
        int[] nums = new int[] { 3, 2, 2, 3 };
        int[] expectedNums = new int[] { 2, 2 };

        test(nums, expectedNums, 3);
    }

    @Test
    public void test1() {
        int[] nums = new int[] { 0, 1, 2, 2, 3, 0, 4, 2 };
        int[] expectedNums = new int[] { 0, 1, 3, 0, 4 };

        test(nums, expectedNums, 2);
    }

    private void test(int[] nums, int[] expectedNums, int val) {
        int k = RemoveElement.removeElement(nums, val);
        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }
}