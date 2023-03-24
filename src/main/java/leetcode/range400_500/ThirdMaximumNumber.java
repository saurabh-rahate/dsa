package leetcode.range400_500;

import java.util.TreeSet;
import java.util.stream.IntStream;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        IntStream.range(0, nums.length).forEach(n -> {
            set.add(nums[n]);
        });

        if(set.size() >= 3) {
            set.pollLast();
            set.pollLast();
        }
        return set.pollLast();
    }
}
