package org.kakao20;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class P3_1_Lock_and_KeyTest {

    @Test
    void solution() {
        // given
        int[][] lock = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] key = new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};

        // when
        P3_1_Lock_and_Key p3 = new P3_1_Lock_and_Key();
        boolean answer = p3.solution(key, lock);

        // then
        Assertions.assertThat(answer).isTrue();
    }

    @Test
    void getExpandedArr() {
        // given
        int[][] lock = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int offset = 2;

        // when
        P3_1_Lock_and_Key p3 = new P3_1_Lock_and_Key();
        int[][] expandedArr = p3.getExpandedArr(lock, offset);

        // then
        for (int[] arr : expandedArr) {
            System.out.println(Arrays.toString(arr));
        }

    }

    @Test
    void pasteKeyToLock() {
        // given
        int[][] lock = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int offset = 2;
        P3_1_Lock_and_Key p3 = new P3_1_Lock_and_Key();
        int[][] expandedArr = p3.getExpandedArr(lock, offset);

        int[][] key = new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int row = 0;
        int col = 0;

        // when
        p3.pasteKeyToLock(key, expandedArr, row, col);

        // then
        for (int[] arr : expandedArr) {
            System.out.println(Arrays.toString(arr));
        }

    }

    @Test
    void validateLock() {
        // given
        int[][] lock = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int offset = 2;
        P3_1_Lock_and_Key p3 = new P3_1_Lock_and_Key();
        int[][] expandedArr = p3.getExpandedArr(lock, offset);

        // when
        boolean answer = p3.validateLock(expandedArr, lock.length, 2);


        // then
        Assertions.assertThat(answer).isFalse();

    }

    @Test
    void validateLock2() {
        // given
        int[][] lock = new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int offset = 2;
        P3_1_Lock_and_Key p3 = new P3_1_Lock_and_Key();
        int[][] expandedArr = p3.getExpandedArr(lock, offset);

        // when
        boolean answer = p3.validateLock(expandedArr, lock.length, 2);


        // then
        Assertions.assertThat(answer).isTrue();

    }

    @Test
    void rotate() {
        // given
        int[][] key = new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] expected = new int[][]{{0, 1, 0}, {1, 0, 0}, {1, 0, 0}};

        // when
        P3_1_Lock_and_Key p3 = new P3_1_Lock_and_Key();
        int[][] answer = p3.rotate(key);

       // then
        Assertions.assertThat(answer).isEqualTo(expected);

    }
}
