package leetcode.range1400_1500;

public class MaximumScoreAfterSplittingAString {
    public static void main(String[] args) {
        System.out.println(maxScore("011101"));
        System.out.println(maxScore("00111"));
        System.out.println(maxScore("1111"));
    }

    public static int maxScore(String s) {
        int sumOfOne = 0;
        int max = 0;
        int sumOfZero = s.charAt(0) == '0' ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                sumOfOne++;
            }
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                sumOfZero++;
            } else {
                sumOfOne--;
            }
            if (max < sumOfOne + sumOfZero)
                max = sumOfZero + sumOfOne;
        }
        return max;
    }
}
