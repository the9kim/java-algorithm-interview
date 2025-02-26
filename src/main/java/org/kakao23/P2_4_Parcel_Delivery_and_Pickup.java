package org.kakao23;

import java.util.Arrays;

public class P2_4_Parcel_Delivery_and_Pickup {

    /**
     * Time-Exceeded
     */
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {

        int turns = calcTurnNum(cap, deliveries, pickups);

        long distance = 0;

        for (int turn = 1; turn <= turns; turn++) {

            int farthest = calcFarthest(deliveries, pickups);

            distance += (farthest + 1) * 2;

            int dCount = cap;
            int pCount = cap;

            for (int i = farthest; i >= 0; i--) {

                if (dCount >= deliveries[i]) {
                    dCount -= deliveries[i];
                    deliveries[i] = 0;
                } else if (dCount < deliveries[i]) {
                    deliveries[i] -= dCount;
                    dCount = 0;
                }

                if (pCount >= pickups[i]) {
                    pCount -= pickups[i];
                    pickups[i] = 0;
                } else if (pCount < pickups[i]) {
                    pickups[i] -= pCount;
                    pCount = 0;
                }

                if (dCount == 0 && pCount == 0) {
                    break;
                }
            }

        }

        return distance;
    }

    public int calcTurnNum(int cap, int[] deliveries, int[] pickups) {
        int dSum = Arrays.stream(deliveries).sum();
        int pSum = Arrays.stream(pickups).sum();
        int max = Math.max(dSum, pSum);
        return max % cap == 0 ? max / cap : max / cap + 1;
    }

    public int calcFarthest(int[] deliveries, int[] pickups) {
        int farthest = deliveries.length - 1;

        for (int i = deliveries.length - 1; i >= 0; i--) {
            if (deliveries[i] != 0 || pickups[i] != 0) {
                farthest = i;
                break;
            }
        }
        return farthest;
    }
}
