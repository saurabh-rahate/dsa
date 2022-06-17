package codechef.selflearning.onestar.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MAKEEQUAL {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            String[] A = br.readLine().split(" ");

            int lowest = Integer.parseInt(A[0]);
            int highest = Integer.parseInt(A[0]);

            for (int i = 1; i < n; i++) {
                int number = Integer.parseInt(A[i]);
                if (number < lowest)
                    lowest = number;
                else if (number > highest)
                    highest = number;
            }
            System.out.println(highest - lowest);
        }
    }

}
