package leetcode;

import java.util.Arrays;

public class MaximumIceCreamBars {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0;
        for (int cost : costs) {
            if (cost <= coins) {
                res++;
                coins -= cost;
            } else break;
        }
        return res;
    }
}
