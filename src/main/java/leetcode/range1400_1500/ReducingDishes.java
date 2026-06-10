package leetcode.range1400_1500;

import java.util.Arrays;

public class ReducingDishes {
    public static void main(String[] args) {
        ReducingDishes obj = new ReducingDishes();
        System.out.println(obj.maxSatisfaction(new int[]{-2, 5, -1, 0, 3, -3}));
        System.out.println(obj.maxSatisfaction(new int[]{-1, -8, 0, 5, -9}));
        System.out.println(obj.maxSatisfaction(new int[]{4, 3, 2}));
        System.out.println(obj.maxSatisfaction(new int[]{-1, -4, -5}));
    }

    public int maxSatisfaction(int[] satisfaction) {

        Arrays.sort(satisfaction);
        if (satisfaction[satisfaction.length - 1] <= 0) return 0;

        int[] scores = new int[satisfaction.length];
        int multiplier = 1;
        int index = -1;
        int maxSum = 0;
        for (int i = 0; i < satisfaction.length; i++) {
            if (satisfaction[i] >= 0) {
                if (index == -1) index = i;
                int score = satisfaction[i] * multiplier++;
                scores[i] = score;
                maxSum += score;
            } else scores[i] = 0;
        }

        if (index == -1 || index == 0) return maxSum;

        int currentSum;
        index--;
        do {
            currentSum = 0;
            for (int i = index; i < satisfaction.length; i++) {
                int score = scores[i] + satisfaction[i];
                scores[i] = score;
                currentSum += score;
            }
            if (currentSum > maxSum) maxSum = currentSum;
            index--;
        } while (currentSum >= maxSum && index >= 0);

        return maxSum;
    }
}
