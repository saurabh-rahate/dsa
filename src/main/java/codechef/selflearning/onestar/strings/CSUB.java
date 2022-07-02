package codechef.selflearning.onestar.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CSUB {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            br.readLine();

            String[] numbers = br.readLine().split("");
            long count = 0;
            for (String letter : numbers) {
                if ("1".equals(letter))
                    count++;
            }
            System.out.println(count * (count + 1) / 2);
        }
    }
}
