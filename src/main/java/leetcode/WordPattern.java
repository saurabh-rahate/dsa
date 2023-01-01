package leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
    }

    public static boolean wordPattern(String pattern, String s) {
        Map<String, String> patternMap = new HashMap<>();
        Map<String, String> wordMap = new HashMap<>();
        String[] patternArray = pattern.split("");
        String[] sArray = s.split(" ");

        if(patternArray.length != sArray.length) return false;

        for (int i = 0; i < patternArray.length; i++) {
            String wordInMap = patternMap.get(patternArray[i]);
            String patternInMap = wordMap.get(sArray[i]);
            if ((patternInMap == null && wordInMap != null) || (wordInMap == null && patternInMap != null))
                return false;
            if (patternInMap != null && wordInMap != null) {
                if(!patternInMap.equals(patternArray[i]) || !wordInMap.equals(sArray[i])) return false;
            }
            if (patternInMap == null && wordInMap == null) {
                wordMap.put(sArray[i], patternArray[i]);
                patternMap.put(patternArray[i], sArray[i]);
            }
        }
        return true;
    }
}
