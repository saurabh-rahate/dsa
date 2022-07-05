package leetcode;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println("3 " + lengthOfLongestSubstring("dvdf"));
        System.out.println("2 " + lengthOfLongestSubstring("au"));
        System.out.println("3 " + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("1 " + lengthOfLongestSubstring("bbbbb"));
        System.out.println("3 " + lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        String prev = s.substring(0, 1);
        int maxLength = 1;
        int currentLength = 1;
        for (int i = 1; i < s.length(); i++) {
            String current = s.substring(i, i + 1);
            int index = prev.indexOf(current);
            if (index > -1) {
                maxLength = currentLength > maxLength ? currentLength : maxLength;
                prev = prev.substring(index + 1) + current;
                currentLength = prev.length();
            } else {
                currentLength++;
                prev = prev + current;
            }
        }
        return maxLength < currentLength ? currentLength : maxLength;
    }
}
