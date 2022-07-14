package leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StringToIntegerTest {

    @Test
    public void name() {
        assertEquals(0, StringToInteger.myAtoi("   "));
        assertEquals(0, StringToInteger.myAtoi("+"));
        assertEquals(0, StringToInteger.myAtoi("words and 987"));
        assertEquals(1, StringToInteger.myAtoi("+1"));
        assertEquals(42, StringToInteger.myAtoi("42"));
        assertEquals(-42, StringToInteger.myAtoi("   -42"));
        assertEquals(-2147483648, StringToInteger.myAtoi("-91283472332"));
    }
}
