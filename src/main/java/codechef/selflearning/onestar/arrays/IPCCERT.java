package codechef.selflearning.onestar.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class IPCCERT {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmk = br.readLine().split(" ");

        int n = Integer.parseInt(nmk[0]);
        int m = Integer.parseInt(nmk[1]);
        int k = Integer.parseInt(nmk[2]);

        int gotCertificate = 0;
        for (int i = 0; i < n; i++) {
            String[] tq = br.readLine().split(" ");
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += Integer.parseInt(tq[j]);
            }
            if (sum >= m && Integer.parseInt(tq[k]) <= 10)
                gotCertificate++;
        }
        System.out.println(gotCertificate);
    }

}
