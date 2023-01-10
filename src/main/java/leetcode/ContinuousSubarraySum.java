package leetcode;

public class ContinuousSubarraySum {
    public static void main(String[] args) {
        System.out.println("true " + checkSubarraySum1(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println("true " + checkSubarraySum1(new int[]{23, 2, 6, 4, 7}, 6));
        System.out.println("false " + checkSubarraySum1(new int[]{23, 2, 6, 4, 7}, 13));
        System.out.println("false " + checkSubarraySum1(new int[]{1, 2, 12}, 6));
        System.out.println("true " + checkSubarraySum1(new int[]{5, 0, 0, 0}, 3));
        System.out.println("true " + checkSubarraySum1(new int[]{1,2,3}, 5));
    }

    public static boolean checkSubarraySum1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % k;
        }

        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
//            if (nums[i] % k == 0) return true;
        }

        return false;
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int beginIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (beginIndex == -1 && (nums[i] == 0 || nums[i] > k)) beginIndex = i;
            if (beginIndex != -1) nums[i] = nums[i] % k;
        }
        beginIndex = beginIndex == -1 ? 0 : beginIndex;
        for (int i = beginIndex; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) return true;
            }
        }
        return false;
    }
}
