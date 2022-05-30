package codechef.selflearning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class INTEST {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nk = br.readLine();
        int n = Integer.parseInt(nk.split(" ")[0]);
        int k = Integer.parseInt(nk.split(" ")[1]);
        int counter = 0;
        while (n-- > 0) {
            int number = Integer.parseInt(br.readLine());
            if (number % k == 0)
                counter++;
        }
        System.out.println(counter);
    }
}
