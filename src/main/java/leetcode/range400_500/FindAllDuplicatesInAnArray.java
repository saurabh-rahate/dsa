package leetcode.range400_500;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicatesInAnArray {

    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(findDuplicates(new int[]{1,1,2}));
        System.out.println(findDuplicates(new int[]{1}));
    }


    public static List<Integer> findDuplicates(int[] nums) {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i] < 0 ? nums[i] * -1 : nums[i];
            if (nums[n - 1] < 0) result.add(n);
            else nums[n - 1] *= -1;
        }
        return new ArrayList<>(result);
    }
}
