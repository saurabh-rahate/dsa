package codechef.selflearning.zerostar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class FLOW002 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String ab = br.readLine();
            System.out.println(Integer.parseInt(ab.split(" ")[0]) % Integer.parseInt(ab.split(" ")[1]));
        }
    }
}
