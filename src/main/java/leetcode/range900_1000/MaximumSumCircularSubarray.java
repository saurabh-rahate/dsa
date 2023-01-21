package leetcode.range900_1000;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class MaximumSumCircularSubarray {
    public static void main(String[] args) {
        MaximumSumCircularSubarray obj = new MaximumSumCircularSubarray();
        System.out.println(obj.maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        System.out.println(obj.maxSubarraySumCircular(new int[]{5, -3, 5}));
        System.out.println(obj.maxSubarraySumCircular(new int[]{-3, -2, -3}));
        System.out.println(obj.maxSubarraySumCircular(new int[]{3, -1, 2, -1}));
    }

    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 1) return nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = max(currentMax + nums[i], nums[i]);
            maxSoFar = max(maxSoFar, currentMax);
            currentMin = min(currentMin + nums[i], nums[i]);
            minSoFar = min(minSoFar, currentMin);
            sum += nums[i];
        }

        return maxSoFar < 0 ? maxSoFar : max(maxSoFar, sum - minSoFar);
    }
}
