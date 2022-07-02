package codechef.selflearning.onestar.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class EQUINOX {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] nab = br.readLine().split(" ");

            int n = Integer.parseInt(nab[0]);
            long a = Integer.parseInt(nab[1]);
            long b = Integer.parseInt(nab[2]);

            long anu = 0, sar = 0;
            for (int i = 0; i < n; i++) {
                String firstLetter = br.readLine().substring(0,1);
                if ("EQUINOX".indexOf(firstLetter) >= 0)
                    sar += a;
                else
                    anu += b;

            }
            if (sar > anu)
                System.out.println("SARTHAK");
            else if (anu > sar)
                System.out.println("ANURADHA");
            else
                System.out.println("DRAW");
        }
    }
}
