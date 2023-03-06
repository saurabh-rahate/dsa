package leetcode.range1500_1600;

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        KthMissingPositiveNumber obj = new KthMissingPositiveNumber();
        System.out.println(obj.findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
        System.out.println(obj.findKthPositive(new int[]{1, 2, 3, 4}, 2));
    }

    public int findKthPositive(int[] arr, int k) {
        int top = 0;
        int n = 1;

        while (k > 0) {
            if (top < arr.length) {
                if (n == arr[top]) {
                    n++;
                    top++;
                } else {
                    k--;
                    n++;
                }
            } else {
                n++;
                k--;
            }

        }
        return n-1;

    }
}
