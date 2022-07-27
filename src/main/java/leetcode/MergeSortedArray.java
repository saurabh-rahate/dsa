package leetcode;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n != 0) {
            if (m == 0) {
                for (int i = 0; i < nums1.length; i++) {
                    nums1[i] = nums2[i];
                }
            } else {
                int end2 = n - 1;
                int end1 = nums1.length - n - 1;

                int index = nums1.length - 1;
                while (index >= 0) {
                    int largest = -1;
                    if (end1 >= 0 && end2 >= 0) {
                        largest = nums2[end2] >= nums1[end1] ? nums2[end2--] : nums1[end1--];
                    } else if (end1 >= 0) {
                        largest = nums1[end1--];
                    } else {
                        largest = nums2[end2--];
                    }
                    nums1[index--] = largest;
                }
            }
        }

    }
}
