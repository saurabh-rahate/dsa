package leetcode;

// https://leetcode.com/problems/divide-two-integers/
public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        boolean isNegative = divisor < 0;
        if (isNegative)
            divisor = -divisor;

        int res = 0;
        while (dividend >= divisor && dividend > 0) {
            dividend -= divisor;
            res++;
        }

        return isNegative ? -res : res;
    }
}
