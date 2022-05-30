package codechef.selflearning.zerostar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class HS08TEST {
    private static final Double WITHDRAW_CHARGE = 0.50;
    private static final Double MULTIPLE = 5.0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String numbers = br.readLine();
        Double amountToWithdraw = Double.parseDouble(numbers.split(" ")[0]);
        Double balance = Double.parseDouble(numbers.split(" ")[1]);

        if (amountToWithdraw % MULTIPLE == 0.0)
            if (balance - amountToWithdraw - WITHDRAW_CHARGE > 0.0) {
                printNumber(balance - amountToWithdraw - WITHDRAW_CHARGE);
                return;
            }
        printNumber(balance);
    }

    private static void printNumber(Double number) {
        System.out.println(String.format("%.2f", number));
    }
}
