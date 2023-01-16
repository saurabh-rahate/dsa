package leetcode.range200_300;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        ContainsDuplicateII obj = new ContainsDuplicateII();

        System.out.println(obj.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(obj.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(obj.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        while (k > 0) {
            if (checkWindowForK(k, nums)) return true;
            k--;
        }
        return false;
    }

    private boolean checkWindowForK(int k, int[] nums) {
        int start = 0;
        int end = k;
        while (end <= nums.length - 1) {
            if (nums[start] == nums[end]) return true;
            start++;
            end++;
        }
        return false;
    }
}
