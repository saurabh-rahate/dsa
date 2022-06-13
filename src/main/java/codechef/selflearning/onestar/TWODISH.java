package codechef.selflearning.onestar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TWODISH {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] nabc = br.readLine().split(" ");

            int n = Integer.parseInt(nabc[0]);
            int a = Integer.parseInt(nabc[1]);
            int b = Integer.parseInt(nabc[2]);
            int c = Integer.parseInt(nabc[3]);

            if(n <= b && (a + c) >= n)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
