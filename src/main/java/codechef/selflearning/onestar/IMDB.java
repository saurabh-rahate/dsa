package codechef.selflearning.onestar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class IMDB {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] nx = br.readLine().split(" ");

            int n = Integer.parseInt(nx[0]);
            final int x = Integer.parseInt(nx[1]);

            int imdb = 0;
            while (n-- > 0) {
                String[] sr = br.readLine().split(" ");
                if (Integer.parseInt(sr[0]) <= x)
                    if (imdb < Integer.parseInt(sr[1]))
                        imdb = Integer.parseInt(sr[1]);
            }
            System.out.println(imdb);
        }
    }
}
