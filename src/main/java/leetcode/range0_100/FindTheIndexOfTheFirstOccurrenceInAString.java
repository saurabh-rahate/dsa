package leetcode.range0_100;

public class FindTheIndexOfTheFirstOccurrenceInAString {

    public static void main(String[] args) {
        FindTheIndexOfTheFirstOccurrenceInAString obj = new FindTheIndexOfTheFirstOccurrenceInAString();

        System.out.println(obj.strStr("sadbutsad", "sad"));
        System.out.println(obj.strStr("leetcode", "leeto"));
        System.out.println(obj.strStr("hello", "ll"));
        System.out.println(obj.strStr("mississippi", "issip"));

    }

    private static int needleLength, haystackLength;

    private static int index;
    private static boolean isPrevCharEqual;

    private static void initialize(int l1, int l2) {
        haystackLength = l1;
        needleLength = l2;
        index = 0;
        isPrevCharEqual = false;
    }

    public int strStr(String haystack, String needle) {
        initialize(haystack.length(), needle.length());

        if (needleLength > haystackLength) return -1;
        if (needleLength == haystackLength) {
            return needle.equals(haystack) ? 0 : -1;
        }

        for (int i = 0; i < needleLength; i++) {
            if (index == haystackLength) {
                isPrevCharEqual = false;
                break;
            }
            isPrevCharEqual = haystack.charAt(index) == needle.charAt(i);
            index++;
            if (!isPrevCharEqual) {
                index = index - i;
                i = -1;
            }
        }


        return isPrevCharEqual ? index - needleLength : -1;
    }
}
