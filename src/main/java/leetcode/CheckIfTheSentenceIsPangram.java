package leetcode;

import java.util.HashSet;
import java.util.Set;

public class CheckIfTheSentenceIsPangram {

    public boolean checkIfPangram(String sentence) {
        Set<Integer> setOfAlphabets = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            setOfAlphabets.add((int) sentence.charAt(i));
            if(setOfAlphabets.size() == 26)
                break;
        }
        if(setOfAlphabets.size() == 26)
            return true;
        return false;
    }
}
