package leetcode;

import java.util.HashMap;
import java.util.Map;

// TODO: Reduce time
public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        Map<Character, Counter> map = new HashMap<>();

        char[] chars = magazine.toCharArray();
        for (char c : chars) {
            Counter count = map.get(c);
            if (count == null) map.put(c, new Counter());
            else count.increment();
        }

        char[] ransomChars = ransomNote.toCharArray();
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
