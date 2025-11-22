package leetcode.range900_1000;

public class FlipStringToMonotoneIncreasing {
    public static void main(String[] args) {
        FlipStringToMonotoneIncreasing obj = new FlipStringToMonotoneIncreasing();

        System.out.println(obj.minFlipsMonoIncr("0101100011"));
    }

    public int minFlipsMonoIncr(String s) {
        int ones = 0;
        int zeros = 0;
        boolean isOneFound = false;
        for (int i = 0; i < s.length(); i++) {
            if (!isOneFound) {
                if (s.charAt(i) == '1') isOneFound = true;
            }

            if (isOneFound) {
                if (s.charAt(i) == '1') ones++;
                else zeros++;
            }

            if (zeros > ones) zeros = ones;
        }

        return Math.min(ones, zeros);
    }
}
