package org.kakao18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class P6_2_Shuttle_Bus {

    /**
     * 1. Convert Time to minutes and calculate bus departing times and Sort the crew list in ascending order by time
     * 2. Find the optimal start time for waiting in line
     */

    public String solution(int n, int t, int m, String[] timetable) {

        // 1.
        Queue<Integer> crews = Arrays.stream(timetable)
                .map(this::convertToMin)
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new));

        // 2.
        int currentBus = 9 * 60;
        int waitingTime = -1;

        for (int bus = 0; bus < n; bus++) {
            for (int seat = 0; seat < m; seat++) {
                if (!crews.isEmpty() && crews.peek() <= currentBus) {
                    waitingTime = crews.poll() - 1;
                } else {
                    waitingTime = currentBus;
                }
            }
            currentBus += t;
        }

        return convertToTime(waitingTime);

    }

    public int convertToMin(String time) {
        String[] tSplit = time.split(":");
        return Integer.valueOf(tSplit[0]) * 60 + Integer.valueOf(tSplit[1]);
    }

    public String convertToTime(int time) {

        return String.format(
                "%02d:%02d",
                time / 60,
                time % 60);
    }

}
