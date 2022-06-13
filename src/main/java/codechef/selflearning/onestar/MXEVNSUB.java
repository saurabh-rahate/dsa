package codechef.selflearning.onestar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MXEVNSUB {
    public static void main(String[] args) throws NumberFormatException,
            IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (sumOfNaturalNumbers(n) % 2 == 0)
                System.out.println(n);
            else
                System.out.println(n - 1);
        }
    }

    private static int sumOfNaturalNumbers(int n) {
        return n * (n + 1) / 2;
    }
}
