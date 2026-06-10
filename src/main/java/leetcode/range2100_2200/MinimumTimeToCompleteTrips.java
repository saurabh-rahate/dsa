package leetcode.range2100_2200;

import java.util.Arrays;

public class MinimumTimeToCompleteTrips {
    public static void main(String[] args) {
        MinimumTimeToCompleteTrips obj = new MinimumTimeToCompleteTrips();
        System.out.println(obj.minimumTime(new int[]{1, 2, 3}, 5));
        System.out.println(obj.minimumTime(new int[]{2}, 1));
        System.out.println(obj.minimumTime(new int[]{5, 10, 10}, 9));
    }

    public long minimumTime(int[] time, int totalTrips) {
//        Arrays.sort(time);
        long timeRequired = 0L;

        while (totalTrips > 0) {
            timeRequired++;
            for (int i : time) {
                if (i == timeRequired || timeRequired % i == 0) {
                    totalTrips--;
                }
                if (totalTrips == 0) break;
            }
            if (totalTrips == 0) break;
        }

        return timeRequired;
    }

}
