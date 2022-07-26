package leetcode;

import java.util.stream.IntStream;

// 69. Sqrt(x)
// https://leetcode.com/problems/sqrtx/
public class SqrtX {
    public static int mySqrt(int x) {
        if (x == 0) return 0;
        if (x < 4) return 1;
        return sqrt(x, 2, x);
    }

    private static int sqrt(int x, int start, int end) {
        int mid = start + (end - start) / 2;
        if (testSqrt(x, mid)) {
            return (long) mid * mid == (long) x ? mid : mid - 1;
        } else {
            if ((long) mid * mid < (long) x)
                start = mid;
            else
                end = mid;
            return sqrt(x, start, end);
        }
    }

    private static boolean testSqrt(long x, long num) {
        return num * num >= x && (num - 1) * (num - 1) < x;
    }
}
