package leetcode;

import java.util.HashMap;
import java.util.Map;

public class UniquePathsII {

    private static int m, n, a = 0, b = 0;
    private static Map<String, Integer> map;

    public static void main(String[] args) {
        System.out.println("Result ===> " + uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println("Result ===> " + uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
        System.out.println("Result ===> " + uniquePathsWithObstacles(new int[][]{{0, 0}, {0, 1}}));

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        map = new HashMap<>();
        m = obstacleGrid.length - 1;
        n = obstacleGrid[0].length - 1;

        if (obstacleGrid[m][n] == 1) return 0;

        return move(a, b, copy(obstacleGrid));
    }

    private static int move(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i > m || j > n) return 0;

        String key = i + "_" + j;
        if (map.containsKey(key)) return map.get(key);

        int ans, gridNumber = grid[i][j];
        if (i == m && j == n) ans = 1;
        else if (gridNumber == 1)  ans = 0;
        else ans = move(i + 1, j, copy(grid)) + move(i, j + 1, copy(grid));

        map.put(key, ans);
        return ans;
    }

    private static int[][] copy(int[][] grid) {
        int[][] copyArray = new int[grid.length][grid[0].length];

        for (int i = 0; i < copyArray.length; i++) {
            System.arraycopy(grid[i], 0, copyArray[i], 0, copyArray[0].length);
        }
        return copyArray;
    }
}
