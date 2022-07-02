package codechef.selflearning.onestar.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ALPHABET {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String result = "Yes";
            String[] word = br.readLine().split("");
            for (int j = 0; j < word.length; j++) {
                if (S.indexOf(word[j]) < 0) {
                    result = "No";
                    break;
                }
            }
            System.out.println(result);
        }
    }
}
