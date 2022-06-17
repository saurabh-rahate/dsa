package codechef.selflearning.onestar.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CSTOCK {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] sabc = br.readLine().split(" ");

            double s = Integer.parseInt(sabc[0]);
            double a = Integer.parseInt(sabc[1]);
            double b = Integer.parseInt(sabc[2]);
            double c = Integer.parseInt(sabc[3]);

            if (percentage(s, c) >= a && percentage(s, c) <= b)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }

    private static double percentage(double n, double percent) {
        return n + n * percent / 100;

    }
}
