package org.kakao20;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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
    void expandLock() {
        // given
        int[][] lock = new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int[][] expected = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 0},
                {0, 0, 1, 1, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        int offset = 2;

        // when
        P3_1_Lock_and_Key p3 = new P3_1_Lock_and_Key();
        int[][] answer = p3.expandLock(lock, offset);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);

    }

    @Test
    void pasteKeyToLock() {
        // given
        int[][] key = new int[][]{
                {0, 0, 0},
                {1, 0, 0},
                {0, 1, 1}
        };
        int[][] expanded = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 0},
                {0, 0, 1, 1, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        int[][] expected = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        int row = 1;
        int col = 4;

        // when
        P3_1_Lock_and_Key p3 = new P3_1_Lock_and_Key();
        p3.pasteKeyToLock(expanded, key, row, col);

        // then
        Assertions.assertThat(expanded).isEqualTo(expanded);

    }

    @Test
    void canUnlock() {
        // given
        int[][] expanded = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        int offset = 2;
        int keySize = 3;

        // when
        P3_1_Lock_and_Key p3 = new P3_1_Lock_and_Key();
        boolean answer = p3.canUnlock(expanded, keySize, offset);

        // then
        Assertions.assertThat(answer).isTrue();

    }

    @Test
    void canNotUnlock() {
        // given
        int[][] expanded = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 0},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        int offset = 2;
        int keySize = 3;

        // when
        P3_1_Lock_and_Key p3 = new P3_1_Lock_and_Key();
        boolean answer = p3.canUnlock(expanded, keySize, offset);

        // then
        Assertions.assertThat(answer).isFalse();

    }

    @Test
    void rotate() {

        // given
        int[][] key = new int[][]{
                {0, 0, 0},
                {1, 0, 0},
                {0, 1, 1}
        };

        int[][] expected = new int[][]{
                {0, 1, 0},
                {1, 0, 0},
                {1, 0, 0}
        };

        // when
        P3_1_Lock_and_Key p3 = new P3_1_Lock_and_Key();
        int[][] rotated = p3.rotate(key);

        // then
        Assertions.assertThat(rotated).isEqualTo(expected);

    }

}
