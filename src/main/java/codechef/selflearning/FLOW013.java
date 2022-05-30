package codechef.selflearning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

class FLOW013 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            Integer sum = Stream.of(br.readLine().split(" ")).map(s -> Integer.parseInt(s)).reduce(0,
                    (a, b) -> (a + b));
            System.out.println(sum == 180 ? "YES" : "NO");
        }
    }
}
