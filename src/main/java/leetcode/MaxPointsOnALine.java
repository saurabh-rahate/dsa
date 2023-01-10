package leetcode;

import java.util.HashMap;

public class MaxPointsOnALine {
    public static void main(String[] args) {
        System.out.println(maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
        System.out.println(maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));
    }

    public static int maxPoints(int[][] points) {
        HashMap<Double, Counter> map = new HashMap<>();
        int maxSlopes = 0;

        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];

            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    double slope = slope(x1, y1, x2, y2);

                    Counter counter = map.get(slope);
                    if (counter == null) map.put(slope, new Counter());
                    else counter.increment();
                }
            }

            int maxSlopesInMap = map.values().stream().map(c -> c.count).max(Integer::compare).orElse(0);
            if (maxSlopesInMap > maxSlopes) maxSlopes = maxSlopesInMap;
            map = new HashMap<>();
        }
        return maxSlopes + 1;
    }

    private static double slope(int x1, int y1, int x2, int y2) {
        return (double) (y2 - y1) / (double) (x2 - x1);
    }

    static class Counter {
        public int count;

        Counter() {
            this.count = 1;
        }

        public void increment() {
            this.count++;
        }

        @Override
        public String toString() {
            return String.valueOf(this.count);
        }
    }
}
