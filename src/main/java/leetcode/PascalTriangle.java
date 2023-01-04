package leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PascalTriangle {

    private static HashMap<Long, BigInteger> factorials = new HashMap<>();

    public static void main(String[] args) {
        generate2(30).forEach(System.out::println);

//        System.out.println(ncr(1,2));
    }

    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            if (i == 1) result.add(List.of(1));
            if (i == 2) result.add(List.of(1, 1));
            if (i >= 3) {
                List<Integer> res = new ArrayList<>();
                res.add(1);
                List<Integer> prevResult = result.get(i - 2);
                for (int j = 1; j <= i - 2; j++) {
                    res.add(prevResult.get(j-1) + prevResult.get(j));
                }
                res.add(1);
                result.add(res);
            }
        }
        return result;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (long i = 1; i <= numRows; i++) {
            if (i == 1) result.add(List.of(1));
            if (i == 2) result.add(List.of(1, 1));
            if (i >= 3) {
                List<Integer> res = new ArrayList<>();
                for (long j = 1; j <= i; j++) {
                    res.add(ncr(i - 1L, j - 1L));
                }
                result.add(res);
            }
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
