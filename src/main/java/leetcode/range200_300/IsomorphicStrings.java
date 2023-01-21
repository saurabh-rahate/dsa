package leetcode.range200_300;

import java.util.*;
import java.util.stream.Collectors;

public class IsomorphicStrings {
    public static void main(String[] args) {
        IsomorphicStrings obj = new IsomorphicStrings();
        System.out.println(obj.isIsomorphic("bbbaaaba", "aaabbbba"));
        System.out.println(obj.isIsomorphic("badc", "baba"));
        System.out.println(obj.isIsomorphic("egg", "add"));
        System.out.println(obj.isIsomorphic("foo", "bar"));
        System.out.println(obj.isIsomorphic("paper", "title"));
    }


    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> tset = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            Character valueInMap = map.get(sChar);
            if (valueInMap == null) {
                map.put(sChar, tChar);
                if (tset.contains(tChar)) return false;
                tset.add(tChar);
            } else {
                if (valueInMap != tChar) return false;
            }
        }
        return true;
    }

    List<Pair> sList = new ArrayList<>();
    List<Pair> tList = new ArrayList<>();

    public boolean isIsomorphic2(String s, String t) {
        char lastAddedSChar = ' ';
        char lastAddedTChar = ' ';
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            if (lastAddedSChar == sChar) {
                sList.get(sList.size() - 1).increment();
            } else {
                lastAddedSChar = sChar;
                sList.add(new Pair(lastAddedSChar));
            }

            char tChar = t.charAt(i);
            if (lastAddedTChar == tChar) {
                tList.get(tList.size() - 1).increment();
            } else {
                lastAddedTChar = tChar;
                tList.add(new Pair(lastAddedTChar));
            }
        }

        if (sList.size() == tList.size())
            for (int i = 0; i < sList.size(); i++) {
                if (sList.get(i).count != tList.get(i).count) return false;
            }


        return sList.size() == tList.size();
    }

    public boolean isIsomorphic1(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            addCharacterCountToMap(s.charAt(i), map1);
            addCharacterCountToMap(t.charAt(i), map2);
        }
        List<Integer> list1 = map1.values().stream().sorted().collect(Collectors.toList());
        List<Integer> list2 = map2.values().stream().sorted().collect(Collectors.toList());

        if (list1.size() != list2.size()) return false;

        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) return false;
        }
        return true;
    }

    private void addCharacterCountToMap(char c, Map<Character, Integer> map) {
        map.merge(c, 1, Integer::sum);
    }

    static class Pair {
        private char c;
        private int count;

        public Pair(char c) {
            this.c = c;
            this.count = 1;
        }

        public void increment() {
            this.count++;
        }
    }
}
