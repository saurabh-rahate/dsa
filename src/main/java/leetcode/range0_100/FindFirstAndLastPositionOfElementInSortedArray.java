package leetcode.range0_100;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray obj = new FindFirstAndLastPositionOfElementInSortedArray();
        obj.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        obj.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        obj.searchRange(new int[]{}, 0);
    }

    public int[] searchRange(int[] nums, int target) {
        int first = nums.length > 0 ? find(nums, target, 0, nums.length - 1) : -1;
        int last = first;

        if (first != -1) {
            int newFirst = Integer.MIN_VALUE;
            int newLast = Integer.MIN_VALUE;

            while (newFirst != -1) {
                newFirst = find(nums, target, 0, first - 1);
                if (newFirst != -1) first = newFirst;
            }

            while (newLast != -1) {
                newLast = find(nums, target, last + 1, nums.length - 1);
                if (newLast != -1) last = newLast;
            }

        }
        return new int[]{first, last};
    }

    public int find(int[] nums, int toFind, int start, int end) {
        if (end < start) return -1;
        int mid = start + ((end - start) / 2);
        if (nums[mid] == toFind) return mid;
        else if (toFind < nums[mid]) return find(nums, toFind, start, mid - 1);
        else return find(nums, toFind, mid + 1, end);

    }
}
