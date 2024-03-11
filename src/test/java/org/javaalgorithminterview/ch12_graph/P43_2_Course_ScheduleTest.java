package org.javaalgorithminterview.ch12_graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P43_2_Course_ScheduleTest {
    @Test
    void canFinish() {
        // given
        P43_2_Course_Schedule p43 = new P43_2_Course_Schedule();
        int numCourses = 3;
        int[][] prerequisites = {{1, 0}, {2, 0}, {2, 1}};

        // when
        boolean answer = p43.canFinish(numCourses, prerequisites);

        // then
        System.out.println(answer);
    }

    @Test
    void canNotFinish() {
        // given
        P43_2_Course_Schedule p43 = new P43_2_Course_Schedule();
        int numCourses = 3;
        int[][] prerequisites = {{1, 2}, {2, 1}};

        // when
        boolean answer = p43.canFinish(numCourses, prerequisites);

        // then
        System.out.println(answer);
    }


}
