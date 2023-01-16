package leetcode.range0_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
        InsertInterval obj = new InsertInterval();
        System.out.println(Arrays.deepToString(obj.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
        System.out.println(Arrays.deepToString(obj.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
        System.out.println(Arrays.deepToString(obj.insert(new int[][]{{1, 5}}, new int[]{2, 7})));
        System.out.println(Arrays.deepToString(obj.insert(new int[][]{{1, 5}}, new int[]{6, 8})));
    }

    private static LinkedList<int[]> res;

    private static void initialize() {
        res = new LinkedList<>();
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};
        initialize();

        int startNewInterval = newInterval[0];
        int endNewInterval = newInterval[1];

        boolean isStartFound = false;
        boolean isEndFound = false;

        for (int[] interval : intervals) {
            if (!isStartFound && startNewInterval <= interval[1]) {
                isStartFound = true;
                startNewInterval = Math.min(startNewInterval, interval[0]);
            }

            if (isStartFound && !isEndFound) {
                if (endNewInterval < interval[0]) {
                    isEndFound = true;
                    addIntervalToArray(startNewInterval, endNewInterval);
                    addIntervalToArray(interval);
                } else if (endNewInterval <= interval[1]) {
                    isEndFound = true;
                    endNewInterval = interval[1];
                    addIntervalToArray(startNewInterval, endNewInterval);
                }
            } else if (isStartFound) {
                addIntervalToArray(interval);
            } else {
                addIntervalToArray(interval);
            }
        }

        if (isStartFound && !isEndFound) {
            addIntervalToArray(startNewInterval, Math.max(endNewInterval, intervals[intervals.length - 1][1]));
        }
        if (!isStartFound && !isEndFound) {
            addIntervalToArray(startNewInterval, endNewInterval);
        }

        return mapListToArray();
    }

    private int[][] mapListToArray() {
        int[][] result = new int[res.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.pollFirst();
        }
        return result;
    }

    private void addIntervalToArray(int start, int end) {
        addIntervalToArray(new int[]{start, end});
    }

    private void addIntervalToArray(int[] interval) {
        res.add(interval);
    }
}
