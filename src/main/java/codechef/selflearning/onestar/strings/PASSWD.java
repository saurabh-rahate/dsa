package codechef.selflearning.onestar.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class PASSWD {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String word = br.readLine();

            boolean isCapitalLetter = false, isSmallLetter = false, isNumber = false, isSpecialChar = false;
            if (word.length() >= 10) {
                for (int j = 1; j < word.length() - 1; j++) {
                    char c = word.charAt(j);

                    if (isCapitalLetter(c)) {
                        isCapitalLetter = true;
                    } else if (isSmallLetter(c)) {
                        isSmallLetter = true;
                    } else if (isNumber(c)) {
                        isNumber = true;
                    } else if (isSpecial(c)) {
                        isSpecialChar = true;
                    }

                }

                if (!isSmallLetter) {
                    if (isSmallLetter(word.charAt(0)) || isSmallLetter(word.charAt(word.length() - 1)))
                        isSmallLetter = true;
                }
            }

            String res = isCapitalLetter && isSmallLetter && isNumber && isSpecialChar ? "YES " : "NO";

            System.out.println(res);
        }

    }

    private static boolean isCapitalLetter(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private static boolean isSmallLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isSpecial(char c) {
        return c == '@' || c == '#' || c == '%' || c == '&' || c == '?';
    }
}
