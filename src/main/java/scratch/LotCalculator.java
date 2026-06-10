package scratch;

public class LotCalculator {

    private static int amountPerLot = 110000;
    private static int profitPerLot = 1100;

    private static int collateral = 110000;
    private static int capital = 0;

    private static int quantityPerLot = 50;

    public static void main(String[] args) {
        for (int day = 1; day <= 1000; day++) {
            int canTakeLot = (capital + collateral) / amountPerLot;
            int totalProfit = canTakeLot * profitPerLot;
            capital += totalProfit;

            if (canTakeLot != (capital + collateral) / amountPerLot)
                System.out.println("Day: " + day + "\t\tLots: " + canTakeLot + "\t\tCapital: " + capital);
        }
    }

}
