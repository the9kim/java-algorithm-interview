package org.javaalgorithminterview.ch12_graph;

import org.junit.jupiter.api.Test;

class P43_1_Course_ScheduleTest {

    @Test
    void canFinish() {
        // given
        P43_1_Course_Schedule p43 = new P43_1_Course_Schedule();
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
        P43_1_Course_Schedule p43 = new P43_1_Course_Schedule();
        int numCourses = 3;
        int[][] prerequisites = {{2, 3}, {3, 2}};

        // when
        boolean answer = p43.canFinish(numCourses, prerequisites);

        // then
        System.out.println(answer);
    }
}
