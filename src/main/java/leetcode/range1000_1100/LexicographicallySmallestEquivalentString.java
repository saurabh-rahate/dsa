package leetcode.range1000_1100;

import java.util.*;
import java.util.stream.Collectors;

public class LexicographicallySmallestEquivalentString {

    public static void main(String[] args) {
        LexicographicallySmallestEquivalentString obj = new LexicographicallySmallestEquivalentString();

        System.out.println(obj.smallestEquivalentString("hello", "world", "hold"));
    }

    private static List<TreeSet<Character>> list;

    private void initialize() {
        list = new LinkedList<>();
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        initialize();
        for (int i = 0; i < s1.length(); i++) {
            mapCharsInSets(s1.charAt(i), s2.charAt(i));
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            res.append(getLowestCharForGivenChar(baseStr.charAt(i)));
        }

        return res.toString();
    }

    private char getLowestCharForGivenChar(char c) {
        return list.stream().filter(treeSet -> treeSet.contains(c)).findFirst().orElseGet(() -> {
            TreeSet<Character> set = new TreeSet<>();
            set.add(c);
            return set;
        }).first();
    }

    private void mapCharsInSets(char a, char b) {
        List<TreeSet<Character>> listOfAlreadyMappedChars = list.stream().filter(treeSet -> treeSet.contains(a) || treeSet.contains(b)).collect(Collectors.toList());
        if (listOfAlreadyMappedChars.size() == 0) {
            TreeSet<Character> set = new TreeSet<>();
            set.add(a);
            set.add(b);
            list.add(set);
        } else if (listOfAlreadyMappedChars.size() == 1) {
            TreeSet<Character> set = listOfAlreadyMappedChars.get(0);
            set.add(a);
            set.add(b);
        } else {
            TreeSet<Character> set1 = listOfAlreadyMappedChars.get(0);
            TreeSet<Character> set2 = listOfAlreadyMappedChars.get(1);
            list.remove(set1);
            list.remove(set2);
            set1.addAll(set2);
            list.add(set1);
        }
    }
}
