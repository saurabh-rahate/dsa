package codechef.selflearning.onestar.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class COLGLF2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int seasonsS = Integer.parseInt(br.readLine());

            String[] introSongDurationQ = br.readLine().split(" ");

            long total = 0;
            for (int i = 0; i < seasonsS; i++) {
                String[] ed = br.readLine().split(" ");

                int episodes = Integer.parseInt(ed[0]);
                for (int j = 1; j <= episodes; j++) {
                    if (j == 1)
                        total += Integer.parseInt(ed[j]);
                    else
                        total += Integer.parseInt(ed[j]) - Integer.parseInt(introSongDurationQ[i]);
                }
            }
            System.out.println(total);
        }
    }

}
