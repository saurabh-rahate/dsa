package codechef.selflearning.onestar.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class COPS {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] mxy = br.readLine().split(" ");

            int m = Integer.parseInt(mxy[0]);
            int x = Integer.parseInt(mxy[1]);
            int y = Integer.parseInt(mxy[2]);

            String[] temp = br.readLine().split(" ");

            int[] M = new int[m];
            for (int i = 0; i < m; i++)
                M[i] = Integer.parseInt(temp[i]);
            Arrays.sort(M);

            int canReach = x * y;
            Police[] poly = new Police[m];
            for (int i = 0; i < m; i++) {
                poly[i] = new Police(M[i] - canReach, M[i] + canReach);
            }

            int res = 100;
            for (int i = 1; i < m; i++) {
                if (poly[i - 1].uppper < poly[i].lower)
                    res -= poly[i - 1].blocked();
                else
                    poly[i].lower = poly[i - 1].lower;
            }

            res -= poly[m - 1].blocked();
            System.out.println(res);
        }
    }
}

class Police {
    int lower;
    int uppper;

    Police(int lower, int uppper) {
        this.lower = lower >= 1 ? lower : 1;
        this.uppper = uppper > 100 ? 100 : uppper;
    }

    public int blocked() {
        return this.uppper - this.lower + 1;
    }
}
