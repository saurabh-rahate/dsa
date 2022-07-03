package codechef.selflearning.onestar.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MAGDOORS {
    private static int wand;
    private static String word;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            wand = 0;
            word = br.readLine();

            int i = 0;
            while (i < word.length()) {
                if (charAt(i) == '1')
                    i++;
                else
                    wand++;
            }
            System.out.println(wand);
        }
    }

    private static char charAt(int i) {
        char c = word.charAt(i);
        if (wand % 2 == 0)
            return c;
        if (c == '1')
            return '0';
        return '1';
    }

}
