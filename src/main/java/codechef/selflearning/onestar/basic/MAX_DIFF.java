package codechef.selflearning.onestar.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MAX_DIFF {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] ns = br.readLine().split(" ");

            int n = Integer.parseInt(ns[0]);
            int s = Integer.parseInt(ns[1]);

            if(s<=n)
                System.out.println(s);
            else
                System.out.println(2* n - s);

        }
    }
}
