package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        letterCombinations("23");
    }
    private static final List<String> mappings = new ArrayList<>();

    static {
        mappings.add("abc");
        mappings.add("def");
        mappings.add("ghi");
        mappings.add("jkl");
        mappings.add("mno");
        mappings.add("pqrs");
        mappings.add("tuv");
        mappings.add("wxyz");
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return Collections.emptyList();
        List<Integer> listOfDigits = Stream.of(digits.split("")).map(Integer::parseInt).collect(Collectors.toList());

        List<String> result = new ArrayList<>();
        for (int i = 0; i < listOfDigits.size(); i++) {

        }
        return null;
    }

    public static void generateCombinations(String ...lettersOnNumber) {
        
    }
}
