package leetcode.range300_400;

public class ValidPerfectSquare {
    public static void main(String[] args) {
        ValidPerfectSquare obj = new ValidPerfectSquare();
        System.out.println(new ValidPerfectSquare().isPerfectSquare(16));
        System.out.println(new ValidPerfectSquare().isPerfectSquare(14));
    }

    public boolean isPerfectSquare(int num) {
        int lengthOfNumber = String.valueOf(num).length() - 1;
        lengthOfNumber = (lengthOfNumber) % 2 == 0 ? lengthOfNumber / 2 : (lengthOfNumber - 1) / 2;
        long number = 1L;
        for (int i = 0; i < lengthOfNumber; i++) {
            number *= 10;
        }
        long square = number * number;
        while (square < (long) num) {
            number++;
            square = number * number;
        }

        return square == num;
    }
}
