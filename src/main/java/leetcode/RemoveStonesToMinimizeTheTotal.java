package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTheTotal {

    public static void main(String[] args) {
        int[] piles = new int[] { 5, 4, 9 };
        System.out.println(minStoneSum(piles, 2));

        System.out.println(minStoneSum(new int[]{4,3,6,7}, 3));
    }

    public static int minStoneSum(int[] piles, int k) {

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < piles.length; i++) {
            q.add(piles[i]);
        }

        while (k-- > 0 && !q.isEmpty()) {
            int n = q.poll();
            n = n - getNewNumberOfStones(n);
            q.add(n);
        }

        int sum = 0;
        while (!q.isEmpty()) {
            sum += q.poll();
        }
        return sum;
    }

    private static int findMaxIndex(int[] piles) {
        int max = 0;
        int index = -1;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] >= max) {
                max = piles[i];
                index = i;
            }
        }
        return index;
    }

    private static int getNewNumberOfStones(int n) {
        return (int) Math.floor(n / 2);
    }


    /*
    *
    *
    * public static int minStoneSum(int[] piles, int k) {
        while (k-- > 0) {
            int index = findMaxIndex(piles);
            piles[index] = piles[index] - getNewNumberOfStones(piles[index]);
        }

        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += piles[i];
        }
        return sum;
    }

    private static int findMaxIndex(int[] piles) {
        int max = 0;
        int index = -1;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] >= max) {
                max = piles[i];
                index = i;
            }
        }
        return index;
>>>>>>> Stashed changes
    }

    private static int getNewNumberOfStones(int n) {
        return (int) Math.floor(n / 2);
    }
<<<<<<< Updated upstream
=======
    * */
}
