package codechef.selflearning.onestar.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BEGGASOL {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            String[] listOfFuels = br.readLine().split(" ");

            int fuel = Integer.parseInt(listOfFuels[0]);
            int position = 0;

                for (int i = 1; i < n; i++) {
                    if (fuel == 0) {
                        break;
                    }
                    position++;
                    fuel = fuel + Integer.parseInt(listOfFuels[i]) - 1;
                    
                }
                System.out.println(fuel + position);
        }
    }

}
