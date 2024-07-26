package org.kakao20;

public class P6_1_External_Wall_Inspection {

    /**
     * 1. Inspect each point sequentially starting from the person who cover the greatest distance
     * 2. Determine the inspection point to minimize the number of people required for the inspection
     */

    int N;
    int[] Weak;
    int[] Dist;
    int minCnt = Integer.MAX_VALUE;

    public int solution(int n, int[] weak, int[] dist) {
        N = n;
        Weak = weak;
        Dist = dist;

        // 1.
        for (int i = 0; i < Weak.length; i++) {
            // 2.
            inspect(1, i, 0);
        }

        if (minCnt == Integer.MAX_VALUE) {
            return -1;
        }
        return minCnt;
    }

    public void inspect(int cnt, int start, int visited) {
        if (cnt > Dist.length) {
            return;
        }

        if (cnt >= minCnt) {
            return;
        }

        for (int i = 0; i < Weak.length; i++) {
            int nextPos = (start + i) % Weak.length;

            int diff = Weak[nextPos] - Weak[start];
            if (nextPos < start) {
                diff += N;
            }
            if (diff > Dist[Dist.length - cnt]) {
                break;
            }
            visited |= 1 << nextPos;
        }

        if (visited == (1 << Weak.length) - 1) {
            minCnt = cnt;
            return;
        }

        for (int i = 0; i < Weak.length; i++) {
            if ((visited & (1 << i)) != 0) {
                continue;
            }
            inspect(cnt + 1, i, visited);
        }
    }

}
