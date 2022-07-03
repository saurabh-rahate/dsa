package codechef.selflearning.onestar.sorting;

import java.util.Arrays;
import java.util.Scanner;

class HORSES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            long[] numbers = new long[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = sc.nextLong();
            }
            Arrays.sort(numbers);

            long diff = numbers[1] - numbers[0];
            int index = 1;

            for (int i = 1; i < n; i++) {
                if ((numbers[i] - numbers[i - 1]) < diff) {
                    diff = numbers[i] - numbers[i - 1];
                    index = i;
                }
            }

            System.out.println(numbers[index] - numbers[index - 1]);
        }
        sc.close();
    }
}
