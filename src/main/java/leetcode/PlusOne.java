package leetcode;

import java.util.stream.IntStream;

// 66. Plus One
// https://leetcode.com/problems/plus-one/
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        boolean hand = true;
        for (int i = digits.length - 1; i >= 0 && hand; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                hand = false;
            }
        }
        return digits[0] == 0 ? addToArray(digits) : digits;
    }

    private static int[] addToArray(int[] digits) {
        int[] nums = new int[digits.length + 1];
        nums[0] = 1;
        for (int i = 1; i < digits.length + 1; i++) {
            nums[i] = digits[i - 1];
        }
        return nums;
    }
}
