package leetcode.range900_1000;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindTheTownJudge {
    public static void main(String[] args) {
        FindTheTownJudge obj = new FindTheTownJudge();
        System.out.println(obj.findJudge(2, new int[][]{{1, 2}}));
        System.out.println(obj.findJudge(3, new int[][]{{1, 3}, {2, 3}}));
        System.out.println(obj.findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
    }

    public int findJudge(int n, int[][] trust) {
        int[] trustedBy = new int[n + 1];

        for (int[] pair : trust) {
            trustedBy[pair[1]]++;
            trustedBy[pair[0]]--;
        }

        for (int i = 1; i <= n; i++) {
            if (trustedBy[i] == n - 1) return i;
        }
        return -1;
    }
}
