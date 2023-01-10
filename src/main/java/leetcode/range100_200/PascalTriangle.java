package leetcode.range100_200;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {


    public static void main(String[] args) {
        generate(30).forEach(System.out::println);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            if (i == 1) result.add(List.of(1));
            if (i == 2) result.add(List.of(1, 1));
            if (i >= 3) {
                List<Integer> res = new ArrayList<>();
                res.add(1);
                List<Integer> prevResult = result.get(i - 2);
                for (int j = 1; j <= i - 2; j++) {
                    res.add(prevResult.get(j - 1) + prevResult.get(j));
                }
                res.add(1);
                result.add(res);
            }
        }
        return result;
    }
}
