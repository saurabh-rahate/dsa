package leetcode;

public class StringToInteger {
    public static int myAtoi(String s) {

        s = s.trim();
        if ("".equals(s))
            return 0;

        String sign = isSign(s.charAt(0)) ? s.substring(0, 1) : "";

        if (!"".equals(sign)) {
            if (s.length() == 1 || !isNumber(s.charAt(1)))
                return 0;
        } else {
            if (!isNumber(s.charAt(0)))
                return 0;
        }

        int end = -1;
        for (int i = "".equals(sign) ? 0 : 1; i < s.length() && end == -1; i++) {
            if (!isNumber(s.charAt(i)))
                end = i;
        }
        end = end == -1 ? s.length() : end;

        try {
            return Integer.parseInt(s.substring(0, end));
        } catch (NumberFormatException e) {
            return s.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }

    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isSign(char c) {
        return c == '+' || c == '-';
    }
}
