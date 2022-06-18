package codechef.selflearning.onestar.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TWOSTR {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] X = br.readLine().split("");
            String[] Y = br.readLine().split("");

            String res = "Yes";
            for (int i = 0; i < X.length; i++) {
                if (!(X[i].equals(Y[i]) || "?".equals(X[i]) || "?".equals(Y[i]))) {
                    res = "No";
                    break;
                }
            }
            System.out.println(res);
        }
    }

}
