package org.javaalgorithminterview.ch7_array;

/**
 * Time exceeded
 * <p>
 * 1. utilize iteration
 * 2. update max profit
 */
public class P12_1_Best_Time_to_Buy_and_Sell_Stock {
    /**
     * 1. move a buying pointer to a day when the price is lower than before
     * 2. move a selling pointer to a day when the price is upper than before
     * 3. update the maxProfit
     */
    public int maxProfit3(int[] prices) {

        double maxProfit = 0;

        int left = 0;
        double buyingPrice = Double.POSITIVE_INFINITY;

        while (left < prices.length - 1) {
            if (buyingPrice > prices[left]) {
                buyingPrice = prices[left];
                int right = left + 1;
                double sellingPrice = Double.NEGATIVE_INFINITY;

                while (right <= prices.length - 1) {
                    if (sellingPrice < prices[right]) {
                        sellingPrice = prices[right];
                        maxProfit = Math.max(maxProfit, sellingPrice - buyingPrice);
                    }
                    right++;
                }
            }
            left++;
        }

        return (int) maxProfit;
    }

    /**
     * The solution the textbook suggests
     *
     * 1.Memorize the minimum price
     * 2.Compare the current price with the minimum price
     * 3.Update the max profit
     */
    public int maxProfit4(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    public int maxProfit(int[] prices) {
        long start = System.currentTimeMillis();

        int maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (i > 0 && prices[i - 1] < prices[i]) {
                continue;
            }
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(profit, maxProfit);
            }
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);

        return maxProfit;
    }

    public int maxProfit2(int[] prices) {

        int maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (i > 0 && prices[i - 1] < prices[i]) {
                continue;
            }

            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] > prices[j] || prices[j - 1] > prices[j]) {
                    continue;
                }
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }


}
