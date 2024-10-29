package org.kakao23;

public class P2_3_Parcel_Delivery_and_Pickup {
    /**
     * Refactored
     */

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int dIdx = n;
        int pIdx = n;

        long distance = 0;

        while (dIdx > 0 || pIdx > 0) {
            dIdx = findFurthestHouse(deliveries, dIdx);
            pIdx = findFurthestHouse(pickups, pIdx);

            distance += Math.max(dIdx, pIdx) * 2;

            dIdx = deliverOrPickup(deliveries, dIdx, cap);
            pIdx = deliverOrPickup(pickups, pIdx, cap);

        }

        return distance;
    }

    private int findFurthestHouse(int[] parcels, int idx) {
        while (idx > 0 && parcels[idx - 1] == 0) {
            idx--;
        }
        return idx;
    }

    private int deliverOrPickup(int[] parcels, int idx, int cap) {
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
