package leetcode;

import org.junit.jupiter.api.Test;
import utils.ArrayExtension;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedArrayTest {
    @Test
    public void test0() {
        int[] num1 = new int[]{1};
        int m = 1;
        int[] nums2 = new int[]{};
        int n = 0;
        int[] expected = new int[]{1};

        MergeSortedArray.merge(num1, m, nums2, n);

        assertTrue(ArrayExtension.areEqual(num1, expected));
    }

    @Test
    public void test1() {
        int[] num1 = new int[]{0};
        int m = 0;
        int[] nums2 = new int[]{1};
        int n = 1;
        int[] expected = new int[]{1};

        MergeSortedArray.merge(num1, m, nums2, n);

        assertTrue(ArrayExtension.areEqual(num1, expected));
    }

    @Test
    public void test() {
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;
        int[] expected = new int[]{1, 2, 2, 3, 5, 6};

        MergeSortedArray.merge(num1, m, nums2, n);

        assertTrue(ArrayExtension.areEqual(num1, expected));
    }


}
