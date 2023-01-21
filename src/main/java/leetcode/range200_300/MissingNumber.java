package leetcode.range200_300;

public class MissingNumber {
    public static void main(String[] args) {
        MissingNumber obj = new MissingNumber();
        System.out.println(obj.missingNumber(new int[]{3, 0, 1}));
    }

    public int missingNumber(int[] nums) {
        int[] tracker = new int[nums.length + 1];
        for (int num : nums) {
            tracker[num]++;
        }
        for (int i = 0; i < tracker.length; i++) {
            if (tracker[i] == 0) return i;
        }
        return -1;
    }
}
