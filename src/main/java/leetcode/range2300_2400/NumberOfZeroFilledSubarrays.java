package leetcode.range2300_2400;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class NumberOfZeroFilledSubarrays {
    public long zeroFilledSubarray(int[] nums) {
        long contCount = 0;
        long subarrays = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                contCount++;
                subarrays += contCount;
            } else {
                contCount = 0;
            }
        }
        return subarrays;
    }

}
