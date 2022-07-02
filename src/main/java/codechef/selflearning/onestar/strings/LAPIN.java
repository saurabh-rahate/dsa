package codechef.selflearning.onestar.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class LAPIN {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String word = br.readLine();

            String first = word.substring(0, word.length() / 2);
            String second = word.length() % 2 == 0 ? word.substring(word.length() / 2)
                    : word.substring((word.length() + 1) / 2);

            String result = "YES";
            for (int i = 0; i < word.length() / 2; i++) {
                String letter = first.substring(0, 1);
                int indexInSecond = second.indexOf(letter);
                if (indexInSecond >= 0) {
                    second = second.replaceFirst(letter, "");
                    first = first.substring(1);
                } else {
                    result = "NO";
                    break;
                }
            }
            System.out.println(result);
        }
    }
}
