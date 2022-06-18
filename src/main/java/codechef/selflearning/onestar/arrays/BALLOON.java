package codechef.selflearning.onestar.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BALLOON {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            br.readLine();

            String[] A = br.readLine().split(" ");

            int max = -1;
            for (int i = 1; i <= 7; i++) {
                int j = 0;
                String number = String.valueOf(i);
                while (!number.equals(A[j])) {
                    j++;
                }
                if (j > max)
                    max = j;
            }
            System.out.println(max + 1);
        }
    }

}
