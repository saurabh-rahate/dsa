package leetcode;

import java.util.HashSet;

public class ValidSudoku {

    private static final char EMPTY = '.';

    public static void main(String[] args) {
        System.out.println(isValidRow(new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'}));

        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'2', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidColumn(board, 1));

        System.out.println(isValidGrid(board, 0, 0));

        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {

        for (char[] nums : board) {
            if (!isValidRow(nums)) return false;
        }

        for (int i = 0; i < board[0].length; i++) {
            if (!isValidColumn(board, i)) return false;
        }

        for (int i = 0; i <= 6; i += 3) {
            for (int j = 0; j <= 6; j += 3) {
                if (!isValidGrid(board, i, j)) return false;
            }
        }
        return true;
    }

    private static boolean isValidGrid(char[][] nums, int a, int b) {
        int inserted = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = a; i < a + 3; i++) {
            for (int j = b; j < b + 3; j++) {
                char num = nums[i][j];
                if (EMPTY != num) {
                    inserted++;
                    set.add(num);
                }
            }
        }
        return set.size() == inserted;
    }

    private static boolean isValidColumn(char[][] nums, int c) {
        int inserted = 0;
        HashSet<Character> set = new HashSet<>();
        for (char[] chars : nums) {
            char num = chars[c];
            if (EMPTY != num) {
                inserted++;
                set.add(num);
            }
        }
        return set.size() == inserted;
    }

    private static boolean isValidRow(char[] nums) {
        int inserted = 0;
        HashSet<Character> set = new HashSet<>();
        for (char num : nums) {
            if (EMPTY != num) {
                inserted++;
                set.add(num);
            }
        }
        return set.size() == inserted;
    }
}
