package leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class PracticeTest {

        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> numbers = new HashMap<>();
            for(int i=0; i<nums.length; i++) {
                numbers.put(nums[i], i);
            }
            
            for(int i=0; i<nums.length; i++) {
                int complement = target - nums[i];
                if(numbers.containsKey(complement) && numbers.get(complement) != i)
                    return new int[] {i, numbers.get(complement)};
            }
            
            return null;
    }

    @Test
    public void test1() {
        int[] nums = { 2, 7, 11, 15 };
        int[] result = twoSum(nums, 9);

        int[] expected = { 0, 1 };

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    @Test
    public void test2() {
        int[] nums = { 3, 2, 4 };
        int[] result = twoSum(nums, 6);

        int[] expected = { 1, 2 };

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    @Test
    public void test3() {
        int[] nums = { 3, 3 };
        int[] result = twoSum(nums, 6);

        int[] expected = { 0, 1 };

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }
}
