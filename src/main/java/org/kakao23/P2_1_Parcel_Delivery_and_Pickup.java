package org.kakao23;

public class P2_1_Parcel_Delivery_and_Pickup {

    /**
     * Time-Exceeded
     *
     * 1. Find the Largest delivery or pickup index whose value is not zero.
     * 2. Utilize iteration from the index in reversed order and sequentially remove elements up to the amount of the capacity size
     */

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        // 1.
        long answer = 0;
        int nonZeroIdx = deliveries.length - 1;
        int dNonZero = n;
        int pNonZero = n;
        boolean isNotEmpty = true;

        while (isNotEmpty) {
            boolean startIdx = false;
            int deliveryCap = cap;
            int pickupCap = cap;
            isNotEmpty = false;

            for (int i = nonZeroIdx; i >= 0; i--) {
                if (startIdx == false && deliveries[i] == 0 && pickups[i] == 0) {
                    continue;
                }
                if (startIdx == false && (deliveries[i] != 0 || pickups[i] != 0)) {
                    startIdx = true;
                    answer += (i + 1) * 2;
                    isNotEmpty = true;
                }
                if (deliveryCap != 0 && deliveries[i] != 0 && deliveries[i] < deliveryCap) {
                    deliveryCap -= deliveries[i];
                    deliveries[i] = 0;
                    dNonZero = i;
                } else if (deliveryCap != 0 && deliveries[i] != 0 && deliveries[i] >= deliveryCap) {
                    deliveries[i] -= deliveryCap;
                    deliveryCap = 0;
                    dNonZero = i;
                }
                if (pickupCap != 0 && pickups[i] != 0 && pickups[i] < pickupCap) {
                    pickupCap -= pickups[i];
                    pickups[i] = 0;
                    pNonZero = i;
                } else if (pickupCap != 0 && pickups[i] != 0 && pickups[i] >= pickupCap) {
                    pickups[i] -= pickupCap;
                    pickupCap = 0;
                    pNonZero = i;
                }
            }
            nonZeroIdx = Math.min(nonZeroIdx, Math.max(dNonZero, pNonZero));
        }
        return answer;
    }
}
