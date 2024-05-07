package org.javaalgorithminterview.ch21_greedy_algorithm;

public class P84_1_Best_Time_to_Buy_and_Sell_Stock2 {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }
}
