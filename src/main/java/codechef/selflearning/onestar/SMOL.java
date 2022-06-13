package codechef.selflearning.onestar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SMOL {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] nk = br.readLine().split(" ");

            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            if (k == 0)
                System.out.println(n);
            else
                System.out.println(n % k);
        }
    }
}
