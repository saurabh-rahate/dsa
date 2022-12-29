package leetcode;

import java.util.TreeSet;

public class RemoveStonesToMinimizeTheTotal {

    public static void main(String[] args) {
        int[] piles = new int[] { 5, 4, 9 };
        System.out.println(minStoneSum(piles, 2));
    }

    public static int minStoneSum(int[] piles, int k) {

        TreeSet<Integer> sortedSet = new TreeSet<>();
        for (int i = 0; i < piles.length; i++)
            sortedSet.add(piles[i]);

        for (int i = 0; i < k; i++) {
            int n = sortedSet.pollLast();
            n = n - getNewNumberOfStones(n);
            sortedSet.add(n);
        }

        int count = 0;
        int l = sortedSet.size();
        for (int i = 0; i < l; i++) {
            count += sortedSet.pollLast();
        }

        return count;
    }

    private static int getNewNumberOfStones(int n) {
        return (int) Math.floor(n / 2);
    }
}
