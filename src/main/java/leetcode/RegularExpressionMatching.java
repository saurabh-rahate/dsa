package leetcode;

import java.util.regex.Pattern;

class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        Pattern pattern = Pattern.compile(p);
        return pattern.matcher(s).matches();
    }
}
