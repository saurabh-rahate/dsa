package leetcode.range100_200;

import java.util.ArrayList;
import java.util.List;

public class ExcelSheetColumnTitle {
    private String result = "";
    private static final int BASE = 26;
    private static final String[] letters = new String[BASE];

    static {
        for (int i = 1; i <= BASE; i++) {
            letters[i - 1] = getLetter(i);
        }
    }

    private static String getLetter(int n) {
        return Character.toString('A' + n - 1);
    }

    public String convertToTitle(int columnNumber) {
        convertToBase(columnNumber, BASE);
        return result;
    }

    private void convertToBase(int n, int base) {
        while (n > 0) {
            int remainder = n % base;
            if (remainder == 0) {
                result = letters[base - 1] + result;
                n = n / base - 1;
            } else {
                result = letters[remainder - 1] + result;
                n = n / base;
            }
        }
    }


//
//    public String convertToTitle(int columnNumber) {
//        if (columnNumber % 26 == 0) {
//            result = "Z" + result;
//            columnNumber = columnNumber / 26 -1;
//            while (columnNumber >= 26) {
//                convertToTitle(columnNumber);
//            }
//            if(columnNumber >= 1) {
//                char newLetter = (char) ('A' + columnNumber - 2);
//                result = newLetter + result;
//            }
//        } else
//            convert(columnNumber);
//        return result;
//    }
//
//    private void convert(int n) {
//        n = extractRemainder(n);
//        workOnQuotient(n);
//    }
//
//    private int extractRemainder(int n) {
//        int r = n % 26;
//        if (r > 0) {
//            char newLetter = (char) ('A' + r - 1);
//            result = newLetter + result;
//        }
//        return n - r;
//    }
//
//    private void workOnQuotient(int n) {
//        if (n > 0) {
//            int d = n / 26;
//            if (d > 26) convert(d);
//            else {
//                char newLetter = (char) ('A' + d - 1);
//                result = newLetter + result;
//            }
//        }
//    }
}
