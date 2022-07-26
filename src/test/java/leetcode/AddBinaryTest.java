package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AddBinaryTest {

    @Nested
    public class BinaryDigitSum {
        @Test
        public void binaryDigitSum00() {
            AddBinary.hand = 0;
            assertEquals(0, AddBinary.addBinaryDigits('0', '0'));
            assertEquals(0, AddBinary.hand);
        }

        @Test
        public void binaryDigitSum01() {
            AddBinary.hand = 0;
            assertEquals(1, AddBinary.addBinaryDigits('0', '1'));
            assertEquals(0, AddBinary.hand);
        }

        @Test
        public void binaryDigitSum10() {
            AddBinary.hand = 0;
            assertEquals(1, AddBinary.addBinaryDigits('1', '0'));
            assertEquals(0, AddBinary.hand);
        }

        @Test
        public void binaryDigitSum11() {
            AddBinary.hand = 0;
            assertEquals(0, AddBinary.addBinaryDigits('1', '1'));
            assertEquals(1, AddBinary.hand);
        }
    }

    @Nested
    public class BinarySumWithHand0 {
        @BeforeEach
        public void setup() {
            AddBinary.hand = 0;
        }

        @Test
        public void binarySumWithHand000() {
            assertEquals(0, AddBinary.binarySumWithHand('0', '0'));
            assertEquals(0, AddBinary.hand);
        }

        @Test
        public void binarySumWithHand001() {
            assertEquals(1, AddBinary.binarySumWithHand('0', '1'));
            assertEquals(0, AddBinary.hand);
        }

        @Test
        public void binarySumWithHand010() {
            assertEquals(1, AddBinary.binarySumWithHand('1', '0'));
            assertEquals(0, AddBinary.hand);
        }

        @Test
        public void binarySumWithHand011() {
            assertEquals(0, AddBinary.binarySumWithHand('1', '1'));
            assertEquals(1, AddBinary.hand);
        }
    }

    @Nested
    public class BinarySumWithHand1 {
        @BeforeEach
        public void setup() {
            AddBinary.hand = 1;
        }

        @Test
        public void binarySumWithHand00() {
            assertEquals(1, AddBinary.binarySumWithHand('0', '0'));
            assertEquals(0, AddBinary.hand);
        }

        @Test
        public void binarySumWithHand01() {
            assertEquals(0, AddBinary.binarySumWithHand('0', '1'));
            assertEquals(1, AddBinary.hand);
        }

        @Test
        public void binarySumWithHand10() {
            assertEquals(0, AddBinary.binarySumWithHand('1', '0'));
            assertEquals(1, AddBinary.hand);
        }

        @Test
        public void binarySumWithHand11() {
            assertEquals(1, AddBinary.binarySumWithHand('1', '1'));
            assertEquals(1, AddBinary.hand);
        }
    }

    @Nested
    public class BinarySumWithHand2 {
        @BeforeEach
        public void setup() {
            AddBinary.hand = 2;
        }

        @Test
        public void binarySumWithHand00() {
            assertEquals(0, AddBinary.binarySumWithHand('0', '0'));
            assertEquals(1, AddBinary.hand);
        }

        @Test
        public void binarySumWithHand01() {
            assertEquals(1, AddBinary.binarySumWithHand('0', '1'));
            assertEquals(1, AddBinary.hand);
        }

        @Test
        public void binarySumWithHand10() {
            assertEquals(1, AddBinary.binarySumWithHand('1', '0'));
            assertEquals(1, AddBinary.hand);
        }

        @Test
        public void binarySumWithHand11() {
            assertEquals(0, AddBinary.binarySumWithHand('1', '1'));
            assertEquals(2, AddBinary.hand);
        }
    }

    @Nested
    public class MainTest {
        @BeforeEach
        public void setup() {
            AddBinary.hand = 0;
        }

        @Test
        public void test1() {
            assertTrue("100".equals(AddBinary.addBinary("11", "1")));
        }

        @Test
        public void test2() {
            assertTrue("10101".equals(AddBinary.addBinary("1010", "1011")));
        }

        @Test
        public void test3() {
            assertTrue("10101".equals(AddBinary.addBinary("1010","1011")));
        }
    }


//    @Test
//    public void hand110() {
//        AddBinary.hand = 1;
//        assertEquals(0, AddBinary.addBinary('1', '0'));
//        assertEquals(1, AddBinary.hand);
//    }
//
//    @Test
//    public void hand101() {
//        AddBinary.hand = 1;
//        assertEquals(0, AddBinary.addBinary('0', '1'));
//        assertEquals(1, AddBinary.hand);
//    }
//
//    @Test
//    public void hand100() {
//        AddBinary.hand = 1;
//        assertEquals(1, AddBinary.addBinary('0', '0'));
//        assertEquals(0, AddBinary.hand);
//    }
//
//    @Test
//    public void hand111() {
//        AddBinary.hand = 1;
//        assertEquals(1, AddBinary.addBinary('1', '1'));
//        assertEquals(1, AddBinary.hand);
//    }

//    @Test
//    public void hand010() {
//        AddBinary.hand = 0;
//        assertEquals(1, AddBinary.addBinary('1', '0'));
//        assertEquals(0, AddBinary.hand);
//    }
//
//    @Test
//    public void hand001() {
//        AddBinary.hand = 0;
//        assertEquals(1, AddBinary.addBinary('0', '1'));
//        assertEquals(0, AddBinary.hand);
//    }
//
//    @Test
//    public void hand000() {
//        AddBinary.hand = 0;
//        assertEquals(0, AddBinary.addBinary('0', '0'));
//        assertEquals(0, AddBinary.hand);
//    }
//
//    @Test
//    public void hand011() {
//        AddBinary.hand = 0;
//        assertEquals(0, AddBinary.addBinary('1', '1'));
//        assertEquals(1, AddBinary.hand);
//    }
}