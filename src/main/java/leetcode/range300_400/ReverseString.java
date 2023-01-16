package leetcode.range300_400;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {
        ReverseString obj = new ReverseString();
        char[] hello = new char[]{'h', 'e', 'l', 'l'};
        obj.reverseString(hello);
        System.out.println(String.valueOf(hello));
    }

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            swapCharsAt(i, s.length - 1 - i, s);
        }
    }

    private static void swapCharsAt(int a, int b, char[] s) {
        char atA = s[a];
        s[a] = s[b];
        s[b] = atA;
    }
}
