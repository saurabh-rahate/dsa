package codechef.selflearning.onestar.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// TODO: Incomplete
class SIGNFLIP {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String nk = br.readLine();

            int n = Integer.parseInt(nk.substring(0, 1));
            int k = Integer.parseInt(nk.substring(1));

            String num = br.readLine();
            int[] numbers = new int[n];

            int negatives = 0;
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(Character.toString(num.charAt(i)));
                if (numbers[i] < 0)
                    negatives++;
            }


            Arrays.sort(numbers);

            if(k>(n-k)) {

            }
            System.out.println(negatives);
        }
    }
}
