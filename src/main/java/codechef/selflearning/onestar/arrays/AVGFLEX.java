package codechef.selflearning.onestar.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// TODO: Visit again
class AVGFLEX {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int[][] counts = new int[101][2];

            int n = Integer.parseInt(br.readLine());

            String[] scores = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                counts[Integer.parseInt(scores[i])][0]++;
            }

            for (int i = 0; i <= 100; i++) {
                if (i == 0)
                    counts[i][1] = counts[i][0];
                else
                    counts[i][1] = counts[i - 1][1] + counts[i][0];
            }

            int boasted = 0;
            for (int i = 0; i <= 100; i++) {
                if (counts[i][0] > 0) {
                    int numberOfStudentsScoredLess = counts[i][1];
                    int numberOfStudentsScoredMore = n - numberOfStudentsScoredLess;
                    if (numberOfStudentsScoredLess > numberOfStudentsScoredMore)
                        boasted += counts[i][0];
                }
            }

            System.out.println(boasted);
        }
    }

}
