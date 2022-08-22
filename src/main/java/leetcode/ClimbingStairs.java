package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    private static Map<Integer, Integer> memo = new HashMap();

    public int climbStairs(int n) {
        if(memo.containsKey(n))
            return memo.get(n);
        if(n<=3)
            return n;
        else {
            int ways = climbStairs(n-1) + climbStairs(n-2);
            memo.put(n, ways);
            return ways;
        }
    }
}
