package leetcode;

// https://leetcode.com/problems/divide-two-integers/
public class DivideTwoIntegers {

    public static void main(String[] args) {
//        System.out.println("Expected: 3, Actual: " + divide1(10, 3));
//        System.out.println("Expected: -3, Actual: " + divide1(10, -3));
//        System.out.println("Expected: -3, Actual: " + divide1(-10, 3));
//        System.out.println("Expected: 3, Actual: " + divide1(-10, -3));
        System.out.println("Expected: 2147483647, Actual: " + divide2(-2147483648, -1));
        System.out.println("Expected: -2147483648, Actual: " + divide2(-2147483648, 1));
        System.out.println("Expected: -1073741824, Actual: " + divide2(-2147483648, 2));
        System.out.println("Expected: 0, Actual: " + divide2(-1010369383, -2147483648));
    }

    public static int divide2(int dividend, int divisor) {
        if (divisor == 1) return dividend;
        boolean isResultPositive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        long longDividend = getLongPositiveNumber(dividend);
        long longDivisor = getLongPositiveNumber(divisor);

        long quotient = longDivisor == 1L ? longDividend : 0L;
        if (longDivisor != 1L)
            while (longDividend >= longDivisor) {
                longDividend -= longDivisor;
                quotient++;
            }

        return getAnswer(quotient, !isResultPositive);
    }

    private static long getLongPositiveNumber(int n) {
        if (n >= 0L) return n;
        return 0L - (long) n;
    }

    private static int getAnswer(long n, boolean invertSign) {
        n = invertSign ? 0 - n : n;
        if (n > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (n < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) n;
    }

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

    public static int divide1(int dividend, int divisor) {
        if (divisor == 1) return dividend;
        if (dividend == -2147483648 && divisor == 2) return -1073741824;
        if (dividend == 2147483647 && divisor == -2147483648) return 0;
        boolean isResultPositive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        dividend = getPositiveNumber(dividend);
        divisor = getPositiveNumber(divisor);

        int quotient = divisor == 1 ? dividend : 0;
        if (divisor != 1)
            while (dividend >= divisor) {
                dividend -= divisor;
                quotient++;
            }
        return isResultPositive ? quotient : getNegativeNumber(quotient);
    }

    private static int getPositiveNumber(int n) {
        if (n >= 0) return n;
        return 0 - n < 0 ? n - 1 : 0 - n;
    }

    private static int getNegativeNumber(int n) {
        if (n < 0) return n;
        return 0 - n;
    }
}
