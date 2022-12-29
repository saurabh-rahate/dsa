package leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class CanIWin {

    public static void main(String[] args) {
        System.out.println(new CanIWin().canIWin(5, 6)); // true
        System.out.println(new CanIWin().canIWin(10, 11)); // false
        System.out.println(new CanIWin().canIWin(10, 0)); // true
        System.out.println(new CanIWin().canIWin(10, 1)); // true
        System.out.println(new CanIWin().canIWin(10, 2)); // true
        System.out.println(new CanIWin().canIWin(10, 3)); // true
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal == 0) return true;
        return canOneWin(maxChoosableInteger, desiredTotal, true, new ArrayList<>());
    }

    private boolean canOneWin(int maxChoosableInteger, int desiredTotal, boolean isFirstPlayerTurn, List<Integer> numbersCovered) {
        if(desiredTotal == 0 && !isFirstPlayerTurn) return true;
        if(desiredTotal <= 0) return false;

        for (int i = 1; i <= maxChoosableInteger ; i++) {
            if(!numbersCovered.contains(i)) {
                List<Integer> newNumbers = new ArrayList<>();
                newNumbers.addAll(numbersCovered);
                newNumbers.add(i);

                int remainder = desiredTotal - i;
                boolean result = canOneWin(maxChoosableInteger, remainder, !isFirstPlayerTurn, newNumbers);

                if(result) return true;
            }

        }

        return false;
    }
}
