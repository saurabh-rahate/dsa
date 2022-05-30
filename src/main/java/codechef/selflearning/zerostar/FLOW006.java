package codechef.selflearning.zerostar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class FLOW006 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int sum = 0;
            String[] digits = br.readLine().split("");
            for (int i = 0; i < digits.length; i++) {
                sum += Integer.parseInt(digits[i]);
            }
            System.out.println(sum);
        }
    }
}
