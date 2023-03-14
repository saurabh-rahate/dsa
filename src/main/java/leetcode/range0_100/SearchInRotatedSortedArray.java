package leetcode.range0_100;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
        System.out.println(obj.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    private static int length;

    protected static void initialize(int l) {
        length = l;
    }

    public int search(int[] nums, int target) {
        initialize(nums.length);
        int start = 0;
        int end = nums.length * 2 - 1;
        int mid = start + (end - start) / 2;

        int index = searchNumber(start, end, nums, target);
        return 0;
    }

    private int searchNumber(int start, int end, int[] nums, int tartget) {
        int mid = start + (end - start) / 2;
        int index = getIndex(mid);
        if (nums[index] == tartget) return index;
        else {
            if (start == end) if (tartget != nums[index]) return -1;
            if (tartget < nums[index]) return searchNumber(start, mid, nums, tartget);
            else return searchNumber(mid, end, nums, tartget);
        }
    }

    protected int getIndex(int i) {
        if (i > length - 1) return i - length;
        else return i;
    }
}
