package leetcode.range100_200;

import java.util.LinkedList;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
        System.out.println(isPalindrome(" "));
    }

    public static boolean isPalindrome(String s) {
        LinkedList<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) queue.add(c);
            else if (c >= 'A' && c <= 'Z') queue.add(Character.toLowerCase(c));
        }

        while (queue.size() > 1) {
            if (queue.pollFirst() != queue.pollLast()) return false;
        }
        return true;
    }
}
