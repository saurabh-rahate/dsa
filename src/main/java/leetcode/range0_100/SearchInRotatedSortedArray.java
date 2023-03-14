package leetcode.range0_100;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
        System.out.println(obj.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(obj.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(obj.search(new int[]{1, 3}, 3));
    }

    private static int result;

    public int search(int[] nums, int target) {
        result = -1;
        searchBinary(0, nums.length - 1, nums, target);
        return result;
    }

    private void searchBinary(int start, int end, int[] nums, int target) {
        if(end < start) return;
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            result = mid;
        } else {
            if (start == end) return;
            if (result == -1)
                searchBinary(start, mid - 1, nums, target);
            if (result == -1)
                searchBinary(mid + 1, end, nums, target);
        }
    }
}
