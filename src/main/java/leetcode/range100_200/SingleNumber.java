package leetcode.range100_200;

import java.util.HashSet;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.remove(n)) {
                set.add(n);
            }
        }

        return set.stream().findFirst().get();
    }
}
