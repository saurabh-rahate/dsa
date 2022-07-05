package leetcode;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println("2\t-> " + findMedianSortedArrays(new int[] { 1, 3 }, new
        int[] { 2 }));
        System.out.println("2.5\t-> " + findMedianSortedArrays(new int[] { 1, 2 }, new
        int[] { 3, 4 }));
        System.out.println("1\t-> " + findMedianSortedArrays(new int[] {}, new int[] {
        1 }));
        System.out.println("2.5\t-> " + findMedianSortedArrays(new int[] {}, new int[]
        { 2, 3 }));
        System.out.println("2\t-> " + findMedianSortedArrays(new int[] { 2, 2, 2 }, new int[] { 2, 2, 2, 2 }));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0)
            return getMedian(nums2);
        if (nums2.length == 0)
            return getMedian(nums1);

        boolean odd = (nums1.length + nums2.length) % 2 != 0;
        int mid = (nums1.length + nums2.length) / 2;
        mid = odd ? mid + 1 : mid;

        int i = 0, j = 0;
        int current = 0;
        while (i < nums1.length || j < nums2.length) {
            int first = i < nums1.length ? nums1[i] : Integer.MAX_VALUE;
            int second = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;
            if (first <= second) {
                current = first;
                i++;
            } else {
                current = second;
                j++;
            }
            if (i + j == mid) {
                if (odd)
                    return (double) current;
                else {
                    int lowest = 0;
                    if (i >= nums1.length)
                        lowest = nums2[j];
                    else if (j >= nums2.length)
                        lowest = nums1[i];
                    else {
                        lowest = nums1[i] <= nums2[j] ? nums1[i] : nums2[j];
                    }
                    return (double) (current + lowest) / 2;
                }
            }
        }
        return 0.0;
    }

    private static double getMedian(int[] num) {
        if (num.length == 1)
            return num[0];
        if (num.length % 2 == 0) {
            return (double) (num[(num.length / 2) - 1] + num[num.length / 2]) / 2;
        } else {
            return num[num.length / 2];
        }
    }
}
