package utils;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayExtensionTest {
    @Nested
    class AreEqualTest {
        @Test
        public void test0() {
            int[] array1 = new int[]{1, 2, 3, 4};
            int[] array2 = new int[]{1, 2, 3, 4};

            assertTrue(ArrayExtension.areEqual(array1, array2));
        }

        @Test
        public void test1() {
            int[] array1 = new int[]{1, 2, 3};
            int[] array2 = new int[]{1, 2, 3, 4};

            assertFalse(ArrayExtension.areEqual(array1, array2));
        }

        @Test
        public void test2() {
            int[] array1 = new int[]{5, 6, 7, 8};
            int[] array2 = new int[]{1, 2, 3, 4};

            assertFalse(ArrayExtension.areEqual(array1, array2));
        }
    }
}
