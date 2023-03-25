package utils;

public class SearchUtils {

    // Searches the index of toFind in nums array
    public static int recursiveBinarySearch(int[] nums, int toFind, int start, int end) {
        if (end < start) return -1;
        int mid = start + ((end - start) / 2);
        if (nums[mid] == toFind) return mid;
        else if (toFind < nums[mid]) return recursiveBinarySearch(nums, toFind, start, mid - 1);
        else return recursiveBinarySearch(nums, toFind, mid + 1, end);
    }
}
