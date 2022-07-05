package codechef.selflearning.onestar.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class DIV03 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] numbers = br.readLine().split(" ");

            int toRemove = Integer.parseInt(br.readLine());

            int difficulty = 0;
            for (int i = 9; i >= 0; i--) {
                int questions = Integer.parseInt(numbers[i]);

                if (toRemove != 0 && questions != 0) {
                    if (questions > toRemove) {
                        difficulty = i + 1;
                        break;
                    }
                    toRemove -= questions;
                } else if (questions != 0) {
                    difficulty = i + 1;
                    break;
                }
            }
            System.out.println(difficulty);
        }
    }
}
