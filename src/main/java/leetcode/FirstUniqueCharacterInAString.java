package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;


// TODO: Reduce time
public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("aabb"));
    }
    public static int firstUniqChar(String s) {
        Map<Character, Counter> map = new LinkedHashMap<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            Counter count = map.get(c);
            if (count == null) map.put(c, new Counter());
            else count.increment();
        }

        for (Map.Entry<Character, Counter> entry : map.entrySet()) {
            if (entry.getValue().count == 1) return s.indexOf(entry.getKey());
        }
        return -1;
    }

    static class Counter {
        public int count;

        Counter() {
            this.count = 1;
        }

        public void increment() {
            this.count++;
        }

        @Override
        public String toString() {
            return String.valueOf(this.count);
        }
    }

}
