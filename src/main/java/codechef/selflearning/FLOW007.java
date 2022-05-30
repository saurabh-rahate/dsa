package codechef.selflearning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class FLOW007 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String number = br.readLine();
            System.out.println(Integer.parseInt(new StringBuffer(number).reverse().toString()));
        }
    }
}
