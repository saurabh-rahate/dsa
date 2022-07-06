package leetcode;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println("2\t-> " + reverse(-123));
    }

    public static int reverse(int x) {
        String reversed = new StringBuffer().append(x).reverse().toString();

        try {
            return x < 0 ? Integer.parseInt(reversed.substring(0, reversed.length() - 1)) * -1
                    : Integer.parseInt(reversed);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
