package leetcode.range300_400;

import java.util.HashSet;
import java.util.stream.IntStream;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        IntStream.range(0, nums1.length).forEach(n -> set.add(nums1[n]));

        HashSet<Integer> result = new HashSet<>();
        IntStream.range(0, nums2.length).forEach(n -> {
            if(set.contains(nums2[n])) result.add(nums2[n]);
        });

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
