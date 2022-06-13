package codechef.selflearning.onestar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class WEIGHTBL {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] abc = br.readLine().split(" ");

            int w1 = Integer.parseInt(abc[0]);
            int w2 = Integer.parseInt(abc[1]);
            int x1 = Integer.parseInt(abc[2]);
            int x2 = Integer.parseInt(abc[3]);
            int m = Integer.parseInt(abc[4]);

            if (w2 <= w1 + m* x2 && w2 >= w1 + m*x1)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
