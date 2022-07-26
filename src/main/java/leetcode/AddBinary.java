package leetcode;

// 67. Add Binary
// https://leetcode.com/problems/add-binary/
public class AddBinary {
    public static int hand;

    public static String addBinary(String a, String b) {
        hand = 0;
        int lengthA = a.length() - 1;
        int lengthB = b.length() - 1;

        StringBuilder result = new StringBuilder();
        while (lengthA >= 0 || lengthB >= 0) {
            if (lengthA >= 0 && lengthB >= 0) {
                result.append(binarySumWithHand(a.charAt(lengthA), b.charAt(lengthB)));
                lengthA--;
                lengthB--;
            } else {
                if (lengthA >= 0) {
                    result.append(binarySumWithHand(a.charAt(lengthA), '0'));
                    lengthA--;
                } else if (lengthB >= 0) {
                    result.append(binarySumWithHand('0', b.charAt(lengthB)));
                    lengthB--;
                }
            }
        }
        if (hand == 1)
            result.append(1);

        return result.reverse().toString();
    }

    public static int binarySumWithHand(char a, char b) {
        if (hand == 0)
            return addBinaryDigits(a, b);
        int result = 0;
        if (hand == 1) {
            result = addBinaryDigits(a, b);
            if (result == 0) {
                result = 1;
                hand--;
            } else {
                result = 0;
            }
        } else if (hand == 2) {
            result = addBinaryDigits(a, b);
            hand--;
        }
        return result;
    }

    public static int addBinaryDigits(char a, char b) {
        if (a != b) {
            return 1;
        } else {
            if (a == '1')
                hand++;
            return 0;
        }
    }

    static class AddBinaryV2 {
        private static final char ZERO = '0';

        public String addBinary(String a, String b) {
            int lengthA = a.length() - 1;
            int lengthB = b.length() - 1;
            int c = 0;

            StringBuilder result = new StringBuilder();
            while (lengthA > 0 || lengthB > 0) {
                int z = 0;
                if (lengthA >= 0)
                    z += a.charAt(lengthA) - ZERO;
                if (lengthB >= 0)
                    z += b.charAt(lengthB) - ZERO;
                z += c;
                result.append(z % 2);
                c = z / 2;
                lengthA--;
                lengthB--;
            }
            if (c != 0)
                result.append(c);
            return result.reverse().toString();
        }
    }
}


