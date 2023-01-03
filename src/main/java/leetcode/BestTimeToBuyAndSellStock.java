package leetcode;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4, 3, 2, 2, 2, 2, 2, 100}));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for(int i=0; i< prices.length; i++ ) {
            if(prices[i] < minPrice) minPrice = prices[i];
            else if(prices[i] - minPrice > maxProfit) maxProfit = prices[i] - minPrice;
        }

        return maxProfit;
    }
}
