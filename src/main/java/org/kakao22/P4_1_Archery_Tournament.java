package org.kakao22;

import java.util.Arrays;

public class P4_1_Archery_Tournament {
    int maxScore = 0;
    int[] info;
    int[] answer = new int[11];

    public int calScore(int[] lion) {
        int score = 0;
        for (int i = 0; i <= 10; i++) {
            if (lion[i] == 0 && info[i] == 0) {
                continue;
            }
            if (lion[i] > info[i]) {
                score += (10 - i);
            } else {
                score -= (10 - i);
            }
        }
        return score;
    }

    public void dfs(int index, int[] lion, int arrow) {
        if (index == 11) {
            lion[10] = arrow;

            int score = calScore(lion);

            if (score > maxScore) {
                maxScore = score;
                answer = Arrays.copyOf(lion, lion.length);
            } else if (score == maxScore) {
                for (int i = 10; i >= 0; i--) {
                    if (lion[i] == answer[i]) {
                        continue;
                    }
                    if (lion[i] > answer[i]) {
                        maxScore = score;
                        answer = Arrays.copyOf(lion, lion.length);
                    }
                    break;
                }
            }
            return;
        }

        if (info[index] < arrow) {
            lion[index] = info[index] + 1;
            dfs(index + 1, lion, arrow - lion[index]);
            lion[index] = 0;
        }
        dfs(index + 1, lion, arrow);
    }

    public int[] solution(int n, int[] info) {
        this.info = info;
        dfs(0, new int[11], n);

        if (maxScore == 0) {
            return new int[]{-1};
        }
        return answer;
    }
}
