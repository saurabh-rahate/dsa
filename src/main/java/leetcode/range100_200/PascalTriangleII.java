package leetcode.range100_200;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        return generate(rowIndex);
    }

    private static HashMap<Long, BigInteger> factorials = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(generate(0));
        System.out.println(generate(1));
        System.out.println(generate(2));
        System.out.println(generate(3));
        System.out.println(generate(33));
    }

    public static List<Integer> generate(int numRows) {
        List<Integer> result = new ArrayList<>();
        for (long j = 0; j <= numRows; j++) {
            result.add(ncr(numRows, j));
        }

        return result;
    }

    private static int ncr(long n, long r) {
        BigInteger a = factorial(n).divide(factorial(r)).divide(factorial(n - r));
        return a.intValue();
    }

    private static BigInteger factorial(long n) {
        if (factorials.containsKey(n)) return factorials.get(n);
        if (n <= 1) return BigInteger.ONE;
        else {
            BigInteger ans = BigInteger.valueOf(n).multiply(factorial(n - 1));
            factorials.put(n, ans);
            return ans;
        }
    }
}
