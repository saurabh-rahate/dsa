package codechef.selflearning.onestar.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class PROGLANG {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String numbers = br.readLine().replace(" ", "");

            String a = numbers.substring(0, 1);
            String b = numbers.substring(1, 2);

            if (numbers.substring(2, 4).contains(a) &&
                    numbers.substring(2, 4).contains(b))
                System.out.println("1");
            else if (numbers.substring(4, 6).contains(a) &&
                    numbers.substring(4, 6).contains(b))
                System.out.println("2");
            else
                System.out.println("0");
        }
    }
}
