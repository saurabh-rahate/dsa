package codechef.selflearning.zerostar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class LUCKFOUR {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int count = 0;
            String[] numbers = br.readLine().split("");
            for (int i = 0; i < numbers.length; i++)
                if ("4".equals(numbers[i]))
                    count++;
            System.out.println(count);
        }
    }
}
