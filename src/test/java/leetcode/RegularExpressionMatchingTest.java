package leetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RegularExpressionMatchingTest {

    @Test
    public void name() {
        assertFalse(RegularExpressionMatching.isMatch("aa", "a"));

        assertTrue(RegularExpressionMatching.isMatch("aa", "a*"));
        assertTrue(RegularExpressionMatching.isMatch("ab", ".*"));
    }
}
