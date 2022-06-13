package codechef.selflearning.onestar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class VDATES {
    private static final String NOW = "Take second dose now";
    private static final String EARLY = "Too Early";
    private static final String LATE = "Too Late";

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] dlr = br.readLine().split(" ");

            int d = Integer.parseInt(dlr[0]);
            int l = Integer.parseInt(dlr[1]);
            int r = Integer.parseInt(dlr[2]);

            if (d >= l) {
                if (r >= d)
                    System.out.println(NOW);
                else
                    System.out.println(LATE);
            } else
                System.out.println(EARLY);

        }
    }
}
