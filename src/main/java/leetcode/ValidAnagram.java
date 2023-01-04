package leetcode;

import java.util.HashMap;
import java.util.Map;

// TODO: Reduce time
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Counter> map = new HashMap<>();

        char[] chars = s.toCharArray();
        for (char c : chars) {
            Counter count = map.get(c);
            if (count == null) map.put(c, new Counter());
            else count.increment();
        }

        char[] ransomChars = t.toCharArray();
        for (char c : ransomChars) {
            Counter count = map.get(c);
            if (count == null || count.count == 0) return false;
            count.decrement();
        }
        return true;
    }

    static class Counter {
        public int count;

        Counter() {
            this.count = 1;
        }

        public void increment() {
            this.count++;
        }

        public void decrement() {
            this.count--;
        }

        @Override
        public String toString() {
            return String.valueOf(this.count);
        }
    }
}
