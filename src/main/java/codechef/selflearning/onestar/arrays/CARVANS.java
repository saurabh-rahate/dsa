package codechef.selflearning.onestar.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CARVANS {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            String[] speeds = br.readLine().split(" ");
            int carsAtMaxSpeed = 1;
            int prevCarSpeed = Integer.parseInt(speeds[0]);

            for (int i = 1; i < n; i++) {
                int currentCarSpeed = Integer.parseInt(speeds[i]);

                if (currentCarSpeed <= prevCarSpeed) {
                    carsAtMaxSpeed++;
                    prevCarSpeed = currentCarSpeed;
                }

            }
            System.out.println(carsAtMaxSpeed);
        }
    }

}
