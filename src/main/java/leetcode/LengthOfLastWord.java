package leetcode;

// 58. Length of Last Word
// https://leetcode.com/problems/length-of-last-word/
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int letterCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char letter = s.charAt(i);
            if ((letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z')) {
                letterCount++;
            } else {
                if (letterCount > 0)
                    break;
            }
        }
        return letterCount;
    }
}
