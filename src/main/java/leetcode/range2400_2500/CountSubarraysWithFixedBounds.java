package leetcode.range2400_2500;

public class CountSubarraysWithFixedBounds {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2, 7, 5};
        int minK = 1;
        int maxK = 5;
        long result = CountSubarraysWithFixedBounds.countSubarrays(nums, minK, maxK);
        System.out.println(result);

        nums = new int[]{1, 1, 1, 1};
        minK = 1;
        maxK = 1;
        result = CountSubarraysWithFixedBounds.countSubarrays(nums, minK, maxK);
        System.out.println(result); // output: 10

    }

    public static long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int countMin = 0, countMax = 0;
        long ans = 0;
        int l = 0, r = 0;

        while (r < n) {
            if (nums[r] >= minK && nums[r] <= maxK) {
                if (nums[r] == minK) {
                    countMin++;
                }
                if (nums[r] == maxK) {
                    countMax++;
                }
                ans += r - l + 1;
                r++;
            } else {
                l = r + 1;
                r = l;
                countMin = 0;
                countMax = 0;
            }
        }

        return ans;
    }


}
