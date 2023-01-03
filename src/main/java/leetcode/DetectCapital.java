package leetcode;

public class DetectCapital {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("leetcode"));
        System.out.println(detectCapitalUse("FlaG"));
    }

    public static boolean detectCapitalUse(String word) {
        if (word.length() == 1) return true;

        boolean firstCapital = isCapitalLetter(word.charAt(0));
        boolean firstSmall = !firstCapital;

        boolean anyCapital = false, anySmall = false;

        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if (isSmallLetter(c)) anySmall = true;
            else anyCapital = true;
        }

        if (firstCapital && anyCapital && !anySmall) return true;
        else if (firstCapital && anySmall && !anyCapital) return true;
        else return firstSmall && anySmall && !anyCapital;
    }

    private static boolean isSmallLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    private static boolean isCapitalLetter(char c) {
        return c >= 'A' && c <= 'Z';
    }
}
