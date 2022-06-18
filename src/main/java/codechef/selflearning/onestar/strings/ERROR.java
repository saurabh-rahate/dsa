package codechef.selflearning.onestar.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ERROR {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String word = br.readLine();

            if (word.contains("010") || word.contains("101"))
                System.out.println("Good");
            else
                System.out.println("Bad");
        }
    }

}
