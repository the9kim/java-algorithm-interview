package org.kakao23;

public class P2_5_Parcel_Delivery_and_Pickup {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int dIdx = n - 1;
        int pIdx = n - 1;

        long distance = 0;

        while (dIdx >= 0 || pIdx >= 0) {
            while (dIdx >= 0 && deliveries[dIdx] == 0) dIdx--;
            while (pIdx >= 0 && pickups[pIdx] == 0) pIdx--;

            int farthest = Math.max(dIdx, pIdx);
            if (farthest < 0) {
                break;
            }
            distance += (farthest + 1) * 2;

            processParcels(dIdx, deliveries, cap);
            processParcels(pIdx, pickups, cap);
        }

        return distance;
    }

    public void processParcels(int idx, int[] houses, int count) {
        while (idx >= 0 && count > 0) {
            int toProcess = Math.min(count, houses[idx]);
            houses[idx] -= toProcess;
            count -= toProcess;
            idx--;
        }
    }
}
