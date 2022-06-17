package codechef.selflearning.onestar.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class HOOPS {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println((n + 1) / 2);
        }
    }
}
