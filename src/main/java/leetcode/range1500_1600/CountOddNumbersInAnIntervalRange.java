package leetcode.range1500_1600;

public class CountOddNumbersInAnIntervalRange {
    public int countOdds(int low, int high) {
        boolean isLowEven = low % 2 == 0;
        boolean isHighEven = high % 2 == 0;

        if (isLowEven) {
            low += 1;
        }

        if (isHighEven) {
            high -= 1;
        }

        return high - low + 1;
    }
}
