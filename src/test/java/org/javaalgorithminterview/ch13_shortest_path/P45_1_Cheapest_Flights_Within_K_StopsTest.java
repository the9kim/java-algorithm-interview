package org.javaalgorithminterview.ch13_shortest_path;

import org.junit.jupiter.api.Test;

class P45_1_Cheapest_Flights_Within_K_StopsTest {

    @Test
    void findCheapestPrice() {
        // given
        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0;
        int dst = 3;
        int k = 1;

        // when
        P45_1_Cheapest_Flights_Within_K_Stops p45 = new P45_1_Cheapest_Flights_Within_K_Stops();
        int cheapestPrice = p45.findCheapestPrice(n, flights, src, dst, k);

        // then
        System.out.println(cheapestPrice);
    }

    @Test
    void findCheapestPrice2() {
        // given
        int n = 3;
        int[][] flights = {{0, 1, 2}, {1, 2, 1}, {2, 0, 10}};
        int src = 1;
        int dst = 2;
        int k = 1;

        // when
        P45_1_Cheapest_Flights_Within_K_Stops p45 = new P45_1_Cheapest_Flights_Within_K_Stops();
        int cheapestPrice = p45.findCheapestPrice(n, flights, src, dst, k);

        // then
        System.out.println(cheapestPrice);
    }

    @Test
    void findCheapestPrice3() {
        // given
        int n = 4;
        int[][] flights = {{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}};
        int src = 0;
        int dst = 3;
        int k = 1;

        // when
        P45_1_Cheapest_Flights_Within_K_Stops p45 = new P45_1_Cheapest_Flights_Within_K_Stops();
        int cheapestPrice = p45.findCheapestPrice(n, flights, src, dst, k);

        // then
        System.out.println(cheapestPrice);
    }

    @Test
    void shouldNot_findCheapestPrice() {
        // given
        int n = 3;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0;
        int dst = 2;
        int k = 0;

        // when
        P45_1_Cheapest_Flights_Within_K_Stops p45 = new P45_1_Cheapest_Flights_Within_K_Stops();
        int cheapestPrice = p45.findCheapestPrice(n, flights, src, dst, k);

        // then
        System.out.println(cheapestPrice);
    }

    @Test
    void shouldNot_findCheapestPrice2() {
        // given
        int n = 5;
        int[][] flights = {{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {3, 1, 1}, {1, 4, 3}};

        int src = 2;
        int dst = 1;
        int k = 1;

        // when
        P45_1_Cheapest_Flights_Within_K_Stops p45 = new P45_1_Cheapest_Flights_Within_K_Stops();
        int cheapestPrice = p45.findCheapestPrice(n, flights, src, dst, k);

        // then
        System.out.println(cheapestPrice);
    }

    @Test
    void shouldNot_findCheapestPrice3() {
        // given
        int n = 2;
        int[][] flights = {{0, 1, 2}};

        int src = 1;
        int dst = 0;
        int k = 0;

        // when
        P45_1_Cheapest_Flights_Within_K_Stops p45 = new P45_1_Cheapest_Flights_Within_K_Stops();
        int cheapestPrice = p45.findCheapestPrice(n, flights, src, dst, k);

        // then
        System.out.println(cheapestPrice);
    }
}
