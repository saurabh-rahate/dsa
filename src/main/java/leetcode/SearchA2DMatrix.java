package leetcode;

public class SearchA2DMatrix {
    public static void main(String[] args) {
//        System.out.println(isFound(new int[]{1, 3, 5, 7, 8}, 0, 4, 10));
        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix[0].length;
        for (int[] nums : matrix) {
            if (target >= nums[0] && target <= nums[length - 1])
                return isFound(nums, 0, length - 1, target);
        }
        return false;
    }

    public static boolean isFound(int[] nums, int start, int end, int target) {
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) return true;
        else if (start == end) return false;
        else if (target <= nums[mid]) return isFound(nums, start, mid, target);
        else return isFound(nums, mid + 1, end, target);
    }
}
