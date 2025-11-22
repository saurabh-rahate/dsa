package leetcode.range700_800;

public class SubarrayProductLessThanK {

    public static void main(String[] args) {
//        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
    }

    private static int result = 0;

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            verifyProduct(1, nums, i, k);
        }
        return result;
    }

    private static void verifyProduct(int product, int[] nums, int index, int requiredProduct) {
        if (index == nums.length) return;
        product *= nums[index];
        if (product < requiredProduct) {
            result++;
            verifyProduct(product, nums, index + 1, requiredProduct);
        }
    }
}
