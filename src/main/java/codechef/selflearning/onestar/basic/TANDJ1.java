package codechef.selflearning.onestar.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TANDJ1 {
    public static void main(String[] args) throws NumberFormatException,
            IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] abcdk = br.readLine().split(" ");

            int a = Integer.parseInt(abcdk[0]);
            int b = Integer.parseInt(abcdk[1]);
            int c = Integer.parseInt(abcdk[2]);
            int d = Integer.parseInt(abcdk[3]);
            int k = Integer.parseInt(abcdk[4]);

            int steps = k - Math.abs(c - a) - Math.abs(d - b);
            if (steps >= 0 && steps % 2 == 0)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }

}
