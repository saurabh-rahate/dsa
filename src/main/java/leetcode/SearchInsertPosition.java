package leetcode;

// 35. Search Insert Position
// https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        return getIndex(nums, target, 0, nums.length - 1);
    }

    private static int getIndex(int[] nums, int target, int start, int end) {
        if (start == end) {
            return target <= nums[start] ? start : start + 1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target)
            return mid;
        if (target <= nums[mid])
            end = mid;
        else
            start = mid + 1;
        return getIndex(nums, target, start, end);
    }
}
