package codechef.selflearning.onestar.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SNAKPROC {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            br.readLine();

            String[] snake = br.readLine().replace(".", "").split("");

            String res = "Valid";
            if ("".equals(snake[0])) {

            } else if (snake.length % 2 != 0) {
                res = "Invalid";
            } else {
                for (int i = 0; i < snake.length; i += 2) {
                    if (!("H".equals(snake[i]) && "T".equals(snake[i + 1]))) {
                        res = "Invalid";
                        break;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
