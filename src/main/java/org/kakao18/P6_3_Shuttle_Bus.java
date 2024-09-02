package org.kakao18;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class P6_3_Shuttle_Bus {

    /** compare with P6_2 solution
     *  It is not necessary to separate the final iteration with others.
     */

    public String solution(int n, int t, int m, String[] timetable) {
        // 1. Convert and Sort the input timetable
        Arrays.sort(timetable);
        Queue<Integer> q = new LinkedList<>();

        for (String tt : timetable) {
            q.add(convertTimeToMin(tt));
        }

        // 2. Calculate the latest arriving time
        int busSchedule = convertTimeToMin("09:00");

        for (int i = 1; i <= n; i++) {
            if (i != 1) {
                busSchedule += t;
            }

            if (i < n) {
                for (int j = 1; j <= m; j++) {
                    if (!q.isEmpty() && q.peek() <= busSchedule) {
                        q.poll();
                    }
                }
            } else {
                for (int j = 1; j < m; j++) {
                    if (!q.isEmpty() && q.peek() <= busSchedule) {
                        q.poll();
                    }
                }
                if (!q.isEmpty() && q.peek() <= busSchedule) {
                    return convertMinToTime(q.peek() - 1);
                } else {
                    return convertMinToTime(busSchedule);
                }
            }
        }
        return "";

    }

    public int convertTimeToMin(String time) {
        String[] timeArr = time.split(":");
        return Integer.valueOf(timeArr[0]) * 60 + Integer.valueOf(timeArr[1]);
    }

    public String convertMinToTime(int min) {
        return String.format("%02d:%02d", min / 60, min % 60);
    }

}
