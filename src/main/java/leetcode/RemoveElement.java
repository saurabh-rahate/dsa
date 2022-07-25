package leetcode;

// 27. Remove Element
// https://leetcode.com/problems/remove-element/
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0 || (nums.length == 1 && nums[0] == val))
            return 0;

        int currentIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[currentIndex] = nums[i];
                currentIndex++;
            }
        }
        return currentIndex;
    }
}
