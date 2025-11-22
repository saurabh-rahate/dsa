package leetcode.range0_100;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FirstMissingPositive {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println(firstMissingPositive(new int[]{1}));
        System.out.println(firstMissingPositive(new int[]{1, 1}));
    }

    public static int firstMissingPositive(int[] nums) {
        boolean oneFound = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) oneFound = true;
            if (nums[i] < 0) nums[i] = 0;
        }

        if (!oneFound) return 1;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n > 0 && nums[n - 1] > 0) {
                nums[n - 1] *= -1;
            } else if (n < 0) {
                n *= -1;
                if (nums[n - 1] > 0)
                    nums[n - 1] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n > 0) return i + 1;
        }
        return nums.length == 1 ? 2 : nums.length;
    }
}
