package leetcode;

import java.util.ArrayList;
import java.util.List;

public class UniquePathsIII {

    public static void main(String[] args) {
        System.out.println("Result ===> " + uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}}));
        System.out.println("Result ===> " + uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}}));
        System.out.println("Result ===> " + uniquePathsIII(new int[][]{{0, 1}, {2, 0}}));

//        System.out.println("Result ===> " + uniquePathsIII(new int[][]{
//                {1, 0, -1, -1},
//                {-1, 0, -1, -1},
//                {-1, 2, -1, -1}
//        }));
    }

    private static int m, n;

    public static int uniquePathsIII(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        int a = -1, b = -1;
        int totalEmpty = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int gridNumber = grid[i][j];
                if (gridNumber == 0) totalEmpty++;
                if (gridNumber == 1) {
                    a = i;
                    b = j;
                }
            }
        }

        int toFind = totalEmpty + 2;

        return move(a, b, copy(grid), toFind);
    }

    private static int move(int i, int j, int[][] grid, int toFind) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 8) return 0;

        if (toFind <= 0) return 0;

        int gridNumber = grid[i][j];
        if (gridNumber == 2 && toFind == 1) return 1;

        if (gridNumber == 2 || toFind == 1 || gridNumber == -1) return 0;
        if (gridNumber == 0 || gridNumber == 1) {
            grid[i][j] = 8;
        }
        toFind--;

        return
                move(i + 1, j, copy(grid), toFind) +
                        move(i, j + 1, copy(grid), toFind) +
                        move(i - 1, j, copy(grid), toFind) +
                        move(i, j - 1, copy(grid), toFind);
    }

    private static int[][] copy(int[][] grid) {
        int[][] copyArray = new int[grid.length][grid[0].length];

//        System.arraycopy(grid, 0, copyArray, 0, grid.length);

        for (int i = 0; i < copyArray.length; i++) {
            for (int j = 0; j < copyArray[0].length; j++) {
                copyArray[i][j] = grid[i][j];
            }
        }
        return copyArray;
    }
}
