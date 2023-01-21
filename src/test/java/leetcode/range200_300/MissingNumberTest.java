package leetcode.range200_300;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MissingNumberTest {

    MissingNumber subject = new MissingNumber();

    @Test
    void test() {
        assertEquals(2, subject.missingNumber(new int[]{3, 0, 1}));
        assertEquals(2, subject.missingNumber(new int[]{0, 1}));
        assertEquals(8, subject.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        assertEquals(2, subject.missingNumber(new int[]{0, 3, 5, 8, 4, 6, 1, 9, 7}));
    }

}