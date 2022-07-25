package leetcode;

// 28. Implement strStr()
// https://leetcode.com/problems/implement-strstr/
public class ImplementStrStr {
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;

        int k = 0;
        boolean match;
        for (int i = 0; i < haystack.length(); i++) {
            match = haystack.charAt(i) == needle.charAt(k);
            if (match) {
                k++;
                if (k == needle.length())
                    return i - k + 1;
            } else {
                i = i - k;
                k = 0;
            }
        }
        return -1;
    }
}
