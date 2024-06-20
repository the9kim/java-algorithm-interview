package org.kakao21;

public class P4_1_Taxi_Ride_Sharing_Fare {

    /**
     * Floyd Warshall Algorithm - Finding the shortest path with waypoints
     *
     * 1. Create a distance array that means the shortest path from one point to another
     * 2. Calculate the shortest path using the map
     */
    static final int INF = 200 * 100000;
    int[][] dist = new int[200][200];
    public int solution(int n, int s, int a, int b, int[][] fares) {

        // 1-1 Initialize a distance array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        // 1-2 Insert values of direct paths
        for (int[] fare : fares) {
            dist[fare[0] - 1][fare[1] - 1] = fare[2];
            dist[fare[1] - 1][fare[0] - 1] = fare[2];
        }

        // 1-3 Update paths with waypoints
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 2.
        s--;
        a--;
        b--;

        int minPath = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            minPath = Math.min(minPath, dist[s][i] + dist[i][a] + dist[i][b]);
        }
        return minPath;

    }
}
