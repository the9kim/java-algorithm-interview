package org.kakao18;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P6_1_Shuttle_Bus {

    /**
     * 1. Convert Time to minutes and calculate bus departing times
     * 2. Filter out crews that starts to wait in the queue after the last bus has departed
     * 3. Sort the crew list in ascending order by times
     * 4. Find the optimal start time for waiting in line
     */

    public String solution(int n, int t, int m, String[] timetable) {

        // 1.
        int firstBus = 9 * 60;

        List<Integer> buses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            buses.add(firstBus + t * i);
        }

        int lastBus = buses.get(buses.size() - 1);

        int limitQTime = 23 * 60 + 59;

        // 2.
        List<Integer> crews = new ArrayList<>();
        for (String time : timetable) {
            int crew = convertToMin(time);
            if (crew <= lastBus) {
                crews.add(crew);
            }
        }

        // 3.
        crews.sort(Comparator.naturalOrder());

        // 4.
        Queue<Integer> q = new LinkedList<>(crews);
        Integer lastCrew = -1;

        for (int i = 0; i < buses.size(); i++) {
            for (int seat = 1; seat <= m; seat++) {
                if (q.isEmpty()) {
                    return convertToTime(lastBus);
                }
                if (q.peek() <= buses.get(i)) {
                    lastCrew = q.poll();
                }
            }
        }

        return convertToTime(lastCrew - 1);

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
