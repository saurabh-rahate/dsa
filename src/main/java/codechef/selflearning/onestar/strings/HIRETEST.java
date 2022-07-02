package codechef.selflearning.onestar.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class HIRETEST {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);

            String[] xy = br.readLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);

            for (int i = 0; i < n; i++) {
                String[] testResult = br.readLine().split("");
                int p = 0, f = 0;
                for (int j = 0; j < m; j++) {
                    if ("F".equals(testResult[j]))
                        f++;
                    else if ("P".equals(testResult[j]))
                        p++;
                }

                if (f >= x || (f >= (x - 1) && p >= y))
                    System.out.print(1);
                else
                    System.out.print(0);
            }
            System.out.println();
        }
    }
}
