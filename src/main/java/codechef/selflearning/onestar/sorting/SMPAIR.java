package codechef.selflearning.onestar.sorting;

import java.util.Arrays;
import java.util.Scanner;

class SMPAIR {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = sc.nextInt();
            }
            Arrays.sort(numbers);

            System.out.println(numbers[0] + numbers[1]);
        }
        sc.close();
    }
}
