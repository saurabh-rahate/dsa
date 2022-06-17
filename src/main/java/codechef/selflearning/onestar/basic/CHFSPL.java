package codechef.selflearning.onestar.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CHFSPL {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] abc = br.readLine().split(" ");

            int a = Integer.parseInt(abc[0]);
            int b = Integer.parseInt(abc[1]);
            int c = Integer.parseInt(abc[2]);

            int sum = a + b + c - Math.min(a, Math.min(b, c));

            System.out.println(sum);
        }
    }
}
