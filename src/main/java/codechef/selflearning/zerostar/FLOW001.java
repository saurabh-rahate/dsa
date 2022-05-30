package codechef.selflearning.zerostar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class FLOW001 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String numbers = br.readLine();
            System.out.println(Integer.parseInt(numbers.split(" ")[0]) + Integer.parseInt(numbers.split(" ")[1]));
        }
    }
}
