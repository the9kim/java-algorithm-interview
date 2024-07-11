package org.kakao23;

public class P2_2_Parcel_Delivery_and_Pickup {

    /**
     *
     * 1. Find the Largest delivery or pickup index whose value is not zero.
     * 2. Utilize iteration from the index in reversed order and sequentially remove elements up to the amount of the capacity size
     */

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int dIdx = n;
        int pIdx = n;

        while (dIdx > 0 || pIdx > 0) {
            while (dIdx > 0 && deliveries[dIdx - 1] == 0) {
                dIdx--;
            }
            while (pIdx > 0 && pickups[pIdx - 1] == 0) {
                pIdx--;
            }
            answer += Math.max(dIdx, pIdx) * 2;

            dIdx = deliverOrPickup(deliveries, cap, dIdx);
            pIdx = deliverOrPickup(pickups, cap, pIdx);
        }
        return answer;
    }

    public int deliverOrPickup(int[] parcels, int cap, int idx) {
        while (idx > 0) {
            if (parcels[idx - 1] > cap) {
                parcels[idx - 1] -= cap;
                break;
            } else {
                cap -= parcels[idx - 1];
                parcels[idx - 1] = 0;
                idx--;
            }
        }
        return idx;
    }
}
