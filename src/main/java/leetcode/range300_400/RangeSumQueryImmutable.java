package leetcode.range300_400;

import java.util.stream.IntStream;

public class RangeSumQueryImmutable {
    class NumArray {

        private int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            IntStream.range(1, nums.length).forEach(n -> {
                this.nums[n] += this.nums[n - 1];
            });
        }

        public int sumRange(int left, int right) {
            if (left == 0) return this.nums[right];
            return nums[right] - nums[left - 1];
        }
    }
}
