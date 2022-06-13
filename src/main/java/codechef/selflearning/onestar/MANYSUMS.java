package codechef.selflearning.onestar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MANYSUMS {
    public static void main(String[] args) throws NumberFormatException,
            IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] lr = br.readLine().split(" ");

            int l = Integer.parseInt(lr[0]);
            int r = Integer.parseInt(lr[1]);

            if (l == r)
                System.out.println(1);
            else
                System.out.println(2 * (r - l) + 1);
        }
    }

}
