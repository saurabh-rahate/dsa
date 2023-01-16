package leetcode.range200_300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerOfTwo {
    public static void main(String[] args) {
        PowerOfTwo obj = new PowerOfTwo();

        System.out.println(obj.isPowerOfTwo(536870912));
        obj.printPowers(30);
    }


    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (n % 2 == 0) {
            if (n / 2 == 1) return true;
            else return isPowerOfTwo(n / 2);
        }
        return n == 1;
    }

    private void printPowers(long n) {
        long res = 1;
        while (n-- > 1) {
            res *= 2;
            System.out.println(res);
        }
    }
}
