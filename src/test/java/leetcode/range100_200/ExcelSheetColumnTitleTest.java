package leetcode.range100_200;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExcelSheetColumnTitleTest {
    ExcelSheetColumnTitle subject;

    @BeforeEach
    public void setup() {
        subject = new ExcelSheetColumnTitle();
    }

    @Test
    public void test0Z() {
        assertEquals("Z", subject.convertToTitle(26));
    }

    @Test
    public void test0AA() {
        assertEquals("AA", subject.convertToTitle(27));
    }

    @Test
    public void test0AZ() {
        assertEquals("AZ", subject.convertToTitle(52));
    }

    @Test
    public void test0CUZ() {
        assertEquals("CUZ", subject.convertToTitle(2600));
    }

    @Test
    public void test1() {
        assertEquals("A", subject.convertToTitle(1));
    }

    @Test
    public void test2() {
        assertEquals("AB", subject.convertToTitle(28));
    }

    @Test
    public void test3() {
        assertEquals("ZY", subject.convertToTitle(701));
    }

    @Test
    public void test4() {
        assertEquals("ALL", subject.convertToTitle(1000));
    }

    @Test
    public void test5() {
        assertEquals("BXX", subject.convertToTitle(2000));
    }

    @Test
    public void test6() {
        assertEquals("DKJ", subject.convertToTitle(3000));
    }

    @Test
    public void test7() {
        assertEquals("KIVH", subject.convertToTitle(200000));
    }
}