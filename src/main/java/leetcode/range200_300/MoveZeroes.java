package leetcode.range200_300;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) return;

        int current = 0;
        int filler = 0;

        while (filler < nums.length) {
            if (nums[filler] != 0) {
                nums[current] = nums[filler];
                current++;
            }
            filler++;
        }

        while (current < filler)
            nums[current++] = 0;
    }
}
