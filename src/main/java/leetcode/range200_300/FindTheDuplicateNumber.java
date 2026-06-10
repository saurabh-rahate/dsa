package leetcode.range200_300;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findDuplicate(new int[]{3, 1, 3, 4, 2}));
        System.out.println(findDuplicate(new int[]{3, 3, 3, 3, 3}));
    }

    public static int findDuplicate(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i] < 0 ? nums[i] * -1 : nums[i];
            if (nums[n - 1] < 0) {
                res = n;
                break;
            } else
                nums[n - 1] *= -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0)
                nums[i] *= -1;
        }

        return res;
    }

//    public static int findDuplicate(int[] nums) {
//        long sum = 0L;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//        }
//
//        sum = sum - (long) nums.length * (nums.length - 1) / 2;
//        return (int) sum;
//    }
}
