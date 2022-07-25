package leetcode;

// 26. Remove Duplicates from Sorted Array
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int number = nums[0];
        int currentIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != number) {
                number = nums[i];
                nums[currentIndex] = number;
                currentIndex++;
            }
        }
        return currentIndex;
    }
}
