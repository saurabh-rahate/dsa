package leetcode.range1400_1500;

public class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {

        int index = 0;
        int[] result = new int[2 * n];
        for (int i = 0; i < n; i++) {
            result[index++] = nums[i];
            result[index++] = nums[i + n];
        }
        return result;
    }
}
