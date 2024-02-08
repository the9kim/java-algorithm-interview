package org.javaalgorithminterview.ch7_array;

import org.assertj.core.api.Assertions;
import org.javaalgorithminterview.ch7_array.P12_1_Best_Time_to_Buy_and_Sell_Stock;
import org.junit.jupiter.api.Test;

class P12_1_Best_Time_to_Buy_and_Sell_StockTest {

    @Test
    void maxProfit() {
        // given
        int[] prices = {7, 1, 5, 3, 6, 4};
        int expected = 5;

        // when
        P12_1_Best_Time_to_Buy_and_Sell_Stock p12 = new P12_1_Best_Time_to_Buy_and_Sell_Stock();
        int maxProfit = p12.maxProfit3(prices);

        // then
        Assertions.assertThat(maxProfit).isEqualTo(expected);
    }
}
