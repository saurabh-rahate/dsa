package leetcode;

// TODO: Visit again to reduce time complexity
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println("2\t-> " + longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 1)
            return s;
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1))
                return s;
            else
                return s.substring(0, 1);
        }

        for (int i = s.length(); i >= 2; i--) {
            String subString = getPallindromeSubStringForGivenLength(s, i);
            if (subString != null) {
                return subString;
            }
        }
        return s.substring(0, 1);
    }

    public static String getPallindromeSubStringForGivenLength(String s, int n) {
        int i = 0, j = n;
        while (i < j && j <= s.length()) {
            String a = s.substring(i, j);

            if (isPallindrome(a))
                return a;
            i++;
            j++;
        }
        return null;
    }

    public static boolean isPallindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
