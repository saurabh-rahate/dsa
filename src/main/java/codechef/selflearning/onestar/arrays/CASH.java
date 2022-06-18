package codechef.selflearning.onestar.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CASH {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] nk = br.readLine().split(" ");

            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] A = br.readLine().split(" ");
            long sum = 0;
            for (int i = 0; i < n; i++)
                sum = sum + Integer.parseInt(A[i]);

            System.out.println(sum % k);
        }
    }

}
