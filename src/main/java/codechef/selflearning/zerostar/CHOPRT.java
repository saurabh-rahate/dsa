package codechef.selflearning.zerostar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CHOPRT {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String ab = br.readLine();
            int a = Integer.parseInt(ab.split(" ")[0]);
            int b = Integer.parseInt(ab.split(" ")[1]);

            if (a == b)
                System.out.println("=");
            else if (a > b)
                System.out.println(">");
            else
                System.out.println("<");
        }
    }
}
