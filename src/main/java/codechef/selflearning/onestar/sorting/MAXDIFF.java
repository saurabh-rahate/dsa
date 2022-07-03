package codechef.selflearning.onestar.sorting;

import java.util.Arrays;
import java.util.Scanner;

class MAXDIFF {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = sc.nextInt();
            }
            Arrays.sort(numbers);

            int boy = 0;
            int baap = 0;

            k = k > (n - k) ? n - k : k;

            for (int i = 0; i < k; i++) {
                boy += numbers[i];
            }
            for (int i = k; i < n; i++) {
                baap += numbers[i];
            }

            System.out.println(baap - boy);
        }
        sc.close();
    }
}
