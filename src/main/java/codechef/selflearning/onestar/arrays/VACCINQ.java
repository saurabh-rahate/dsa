package codechef.selflearning.onestar.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class VACCINQ {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] npxy = br.readLine().split(" ");

            int p = Integer.parseInt(npxy[1]);
            int x = Integer.parseInt(npxy[2]);
            int y = Integer.parseInt(npxy[3]);

            String[] queue = br.readLine().split(" ");
            int adult = 0, child = 0;
            for (int i = 0; i < p; i++) {
                if ("0".equals(queue[i]))
                    child++;
                else
                    adult++;
            }
            System.out.println(x * child + y * adult);

        }
    }
}
