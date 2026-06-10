package leetcode.range900_1000;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.IntStream;

// TODO: Fix Approach
public class MinimumCostForTickets {
    public static void main(String[] args) {
        MinimumCostForTickets obj = new MinimumCostForTickets();
        System.out.println(obj.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{7, 2, 15}));
        System.out.println(obj.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
        System.out.println(obj.mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15}));
    }

    PLAN ONE_DAY;
    PLAN SEVEN_DAY;
    PLAN THIRTY_DAY;

    int MINIMUM_COST;

    HashMap<Integer, Integer> map;

    public void initialize(int[] costs) {
        ONE_DAY = new PLAN(costs[0], 0);
        SEVEN_DAY = new PLAN(costs[1], 6);
        THIRTY_DAY = new PLAN(costs[2], 29);
        MINIMUM_COST = Arrays.stream(costs).min().getAsInt();
        map = new HashMap<>();
    }

    public int mincostTickets(int[] days, int[] costs) {
        initialize(costs);
        IntStream.range(0, days.length).forEach(index -> {
            map.put(days[index], index);
        });
        return Math.min(
                getMinCost(days, indexCoveredUntil(days[0] + ONE_DAY.days), costs[0]),
                Math.min(
                        getMinCost(days, indexCoveredUntil(days[0] + SEVEN_DAY.days), costs[1]),
                        getMinCost(days, indexCoveredUntil(days[0] + THIRTY_DAY.days), costs[2])
                )
        );
    }

    private int indexCoveredUntil(int dayCovered) {
        try {
            return map.get(map.keySet().stream().filter(day -> day <= dayCovered).max(Comparator.naturalOrder()).get());
        } catch (Exception e) {
            System.out.println();
        }
        return 0;
    }

    private int getMinCost(int[] days, int indexCoveredUntil, int costUntil) {
        if (indexCoveredUntil == days.length - 1) {
            return costUntil;
        } else {
            return Math.min(
                    getMinCost(days, indexCoveredUntil(days[indexCoveredUntil + 1] + ONE_DAY.days), costUntil + ONE_DAY.cost),
                    Math.min(
                            getMinCost(days, indexCoveredUntil(days[indexCoveredUntil + 1] + SEVEN_DAY.days), costUntil + SEVEN_DAY.cost),
                            getMinCost(days, indexCoveredUntil(days[indexCoveredUntil + 1] + THIRTY_DAY.days), costUntil + THIRTY_DAY.cost)
                    )
            );
        }


//        if (index == days.length - 1) {
//            if (days[index] <= daysWithCurrentCost) {
//                return costUntil;
//            } else {
//                return costUntil + MINIMUM_COST;
//            }
//        } else {
//            if (days[index] <= daysWithCurrentCost) {
//                return getMinCost(days, index + 1, costUntil, daysWithCurrentCost);
//            } else {
//                return Math.min(
//                        getMinCost(days, index + 1, costUntil + ONE_DAY.cost, days[index] + ONE_DAY.days),
//                        Math.min(
//                                getMinCost(days, index + 1, costUntil + SEVEN_DAY.cost, days[index] + SEVEN_DAY.days),
//                                getMinCost(days, index + 1, costUntil + THIRTY_DAY.cost, days[index] + THIRTY_DAY.days)
//                        )
//                );
//            }
//        }
    }

    private static class PLAN {
        int cost, days;

        public PLAN(int cost, int days) {
            this.cost = cost;
            this.days = days;
        }
    }
}
