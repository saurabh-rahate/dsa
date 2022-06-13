package codechef.selflearning.onestar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class PROBCAT {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x >= 1 && x < 100)
                System.out.println("Easy");
            else if (x >= 100 && x < 200)
                System.out.println("Medium");
            else
                System.out.println("Hard");
        }
    }
}
