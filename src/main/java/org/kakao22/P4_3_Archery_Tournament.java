package org.kakao22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P4_3_Archery_Tournament {

    int[] maxLion = new int[]{-1};
    int maxScore = 0;

    public int[] solution(int n, int[] info) {
        dfs(info, new int[11], n, 0);
        return maxLion;
    }

    public void dfs(int[] apeach, int[] lion, int n, int idx) {
        if (n <= 0) {
            int diff = calculateDiff(apeach, lion);
            if (maxScore < diff) {
                maxScore = diff;
                maxLion = Arrays.copyOf(lion, 11);
            } else if (maxScore == diff) {
                if (hasLowerElem(lion, this.maxLion)) {
                    maxLion = Arrays.copyOf(lion, 11);
                }
            }
            return;
        }

        for (int i = idx; i < apeach.length; i++) {
            if (n > apeach[i]) {
                lion[i] = apeach[i] + 1;
            } else if (n > 0 && i == 10) {
                lion[i] = n;
            }
            dfs(apeach, lion, n - (apeach[i] + 1), i + 1);

            lion[i] = 0;
        }
    }

    public int calculateDiff(int[] apeach, int[] lion) {
        int diff = 0;

        for (int i = 0; i < 11; i++) {
            if (apeach[i] == 0 && lion[i] == 0) {
                continue;
            } else if (lion[i] > apeach[i]) {
                diff += (10 - i);
            } else if(lion[i] <= apeach[i]) {
                diff -= (10 - i);
            }
        }

        return diff;
    }

    public boolean hasLowerElem(int[] lion, int[] maxLion) {

        for (int i = 10; i >= 0; i--) {
            if (lion[i] == 0 && maxLion[i] == 0) {
                continue;
            }
            if (lion[i] > 0 && maxLion[i] == 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }



}
