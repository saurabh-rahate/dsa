package codechef.selflearning.onestar.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class NFS {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] uvas = br.readLine().split(" ");

            int u = Integer.parseInt(uvas[0]);
            int v = Integer.parseInt(uvas[1]);
            int a = Integer.parseInt(uvas[2]);
            int s = Integer.parseInt(uvas[3]);

            if ((v * v) >= (u * u) - (2 * a * s))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}
