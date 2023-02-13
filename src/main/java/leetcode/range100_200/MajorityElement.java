package leetcode.range100_200;

import java.util.HashMap;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Result result = new Result(Integer.MIN_VALUE, Integer.MIN_VALUE);

        for (int num : nums) {
            int count = map.merge(num, 1, Integer::sum);

            if (result.maxValue < count) {
                result.maxValue = count;
                result.maxKey = num;
            }
        }
        return result.maxKey;
    }

    static class Result {
        int maxKey, maxValue;

        Result(int k, int v) {
            this.maxKey = k;
            this.maxValue = v;
        }
    }
}
