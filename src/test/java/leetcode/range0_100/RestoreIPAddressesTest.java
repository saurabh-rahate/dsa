package leetcode.range0_100;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RestoreIPAddressesTest {
    private RestoreIPAddresses subject;

    @BeforeEach
    void setup() {
        subject = new RestoreIPAddresses();
    }

    @Test
    void test1() {
        assertEquals(0, subject.restoreIpAddresses("").size());
        assertEquals(0, subject.restoreIpAddresses("1").size());
        assertEquals(0, subject.restoreIpAddresses("12").size());
        assertEquals(0, subject.restoreIpAddresses("123").size());
    }

    @Test
    void test2() {
        assertEquals(List.of("0.0.0.0"), subject.restoreIpAddresses("0000"));
    }

    @Test
    void test3() {
        assertEquals(List.of("255.255.11.135", "255.255.111.35").size(), subject.restoreIpAddresses("25525511135").size());
        assertEquals(List.of("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3").size(),
                subject.restoreIpAddresses("101023").size());
    }
}