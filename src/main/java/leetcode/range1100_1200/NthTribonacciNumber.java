package leetcode.range1100_1200;

import java.util.HashMap;

public class NthTribonacciNumber {
    public static void main(String[] args) {
        NthTribonacciNumber obj = new NthTribonacciNumber();
        System.out.println(obj.tribonacci(25));
    }

    static HashMap<Integer, Integer> map = new HashMap<>();

    static {
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 1);
    }

    public int tribonacci(int n) {
        if (map.containsKey(n)) return map.get(n);
        int res = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        map.put(n, res);
        return res;
    }
}
