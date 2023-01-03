package leetcode;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {

    public static void main(String[] args) {

        System.out.println(new UniquePaths().uniquePaths(22, 22));
    }

    private Map<String, Integer> map = new HashMap<>();

    private int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        if (map.containsKey(m + "_" + n)) return map.get(m + "_" + n);
        int ans = uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        map.put(m + "_" + n, ans);
        return ans;

    }


}
