package codechef.selflearning.onestar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CHFRICH {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] abx = br.readLine().split(" ");
            int years = (Integer.parseInt(abx[1]) - Integer.parseInt(abx[0])) / Integer.parseInt(abx[2]);
            System.out.println(years);
        }
    }
}
