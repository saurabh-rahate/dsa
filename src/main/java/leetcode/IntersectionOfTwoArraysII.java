package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        List<Integer> list = new LinkedList<>();
        for (int j : nums1) {
            list.add(j);
        }

        for (int j : nums2) {
            if (list.remove(Integer.valueOf(j))) {
                res.add(j);
            }
        }


        return res.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
