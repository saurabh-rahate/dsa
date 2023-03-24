package leetcode.range400_500;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] tracker = new int[nums.length + 1];
        IntStream.range(0, nums.length).forEach(n -> {
            tracker[nums[n]] = 1;
        });
        List<Integer> result = new ArrayList<>();
        IntStream.rangeClosed(1, nums.length).filter(n -> tracker[n] == 0).forEach(result::add);
        return result;
    }
}
