package codechef.selflearning.onestar.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class NOBEL {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] nm = br.readLine().split(" ");

            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);

            String[] topics = br.readLine().split(" ");

            int[] isTopicTaken = new int[m + 1];

            for (int i = 0; i < n; i++) {
                isTopicTaken[Integer.parseInt(topics[i])]++;
            }

            String res = "No";
            for (int i = 1; i <= m; i++) {
                if (isTopicTaken[i] == 0) {
                    res = "Yes";
                    break;
                }
            }
            System.out.println(res);
        }
    }

}
