package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

    private Map<String, Boolean> memo = new HashMap<>();

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();

        System.out.println(wb.wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(wb.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(wb.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(
                wb.wordBreak(
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if(memo.containsKey(s)) return memo.get(s);
        if ("".equals(s)) return true;

        for (String word : wordDict) {
            boolean result = false;
            if(s.startsWith(word)) {
                String newWord = s.substring(word.length());
                result = wordBreak(newWord, wordDict);
                memo.put(newWord, result);
            }
            if (result)
                return true;
        }
        memo.put(s, false);
        return false;
    }
}
