package codechef.selflearning.onestar.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SUBTASK {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] nmk = br.readLine().split(" ");

            int n = Integer.parseInt(nmk[0]);
            int m = Integer.parseInt(nmk[1]);
            int k = Integer.parseInt(nmk[2]);

            String[] A = br.readLine().split(" ");

            int testPasses = n;
            for (int i = 0; i < n; i++) {
                if ("0".equals(A[i])) {
                    testPasses = i;
                    break;
                }
            }
            if (testPasses == n)
                System.out.println(100);
            else if (testPasses >= m)
                System.out.println(k);
            else
                System.out.println(0);
        }
    }

}
