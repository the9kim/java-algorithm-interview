package org.javaalgorithminterview.ch12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P42_1_Travel_Route_43164Test {

    @Test
    void solution() {
        // given
        String[][] tickets = new String[][]{
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL", "SFO"}
        };

        // when
        P42_1_Travel_Route_43164 p42 = new P42_1_Travel_Route_43164();
        String[] answer = p42.solution(tickets);

        // then
        for (String a : answer){
            System.out.println(a);
        }
    }

    @Test
    void solution2() {
        // given
        String[][] tickets = new String[][]{
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        };

        // when
        P42_1_Travel_Route_43164 p42 = new P42_1_Travel_Route_43164();
        String[] answer = p42.solution(tickets);

        // then
        for (String a : answer){
            System.out.println(a);
        }
    }
}
