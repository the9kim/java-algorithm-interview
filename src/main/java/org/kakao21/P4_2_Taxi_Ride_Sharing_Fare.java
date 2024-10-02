package org.kakao21;

public class P4_2_Taxi_Ride_Sharing_Fare {

    static final int MAX_FARE = 200 * 100000;
    int[][] fareArr;
    int n;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        initDistanceArray();

        setUpDirectPath(fares);

        updatePathWithWayPoints();

        return findMinFare(s - 1, a - 1, b - 1);
    }

    private void initDistanceArray() {
        this.fareArr = new int[n][n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (r == c) {
                    fareArr[r][c] = 0;
                } else {
                    fareArr[r][c] = MAX_FARE;
                }
            }
        }
    }

    private void setUpDirectPath(int[][] fares) {
        for (int[] fare : fares) {
            fareArr[fare[0] - 1][fare[1] - 1] = fare[2];
            fareArr[fare[1] - 1][fare[0] - 1] = fare[2];
        }
    }

    private void updatePathWithWayPoints() {
        for (int k = 0; k < n; k++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (fareArr[r][c] > fareArr[r][k] + fareArr[k][c]) {
                        fareArr[r][c] = fareArr[r][k] + fareArr[k][c];
                    }
                }
            }
        }
    }

    private int findMinFare(int s, int a, int b) {

        int minFare = Integer.MAX_VALUE;

        for (int wp = 0; wp < n; wp++) {
            int fare = fareArr[s][wp] + fareArr[wp][a] + fareArr[wp][b];
            minFare = Math.min(minFare, fare);
        }

        return minFare;
    }
}
