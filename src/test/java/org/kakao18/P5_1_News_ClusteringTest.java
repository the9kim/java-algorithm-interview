package org.kakao18;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P5_1_News_ClusteringTest {

    @Test
    void newCluster() {
        // given
        String str1 = "FRANCE";
        String str2 = "french";
        int expected = 16384;

        // when
        P5_1_News_Clustering p5 = new P5_1_News_Clustering();
        int answer = p5.solution(str1, str2);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void newCluster2() {
        // given
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";
        int expected = 43690;

        // when
        P5_1_News_Clustering p5 = new P5_1_News_Clustering();
        int answer = p5.solution(str1, str2);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void newCluster3() {
        // given

        String str1 = "handshake";
        String str2 = "shake hands";
        int expected = 65536;

        // when
        P5_1_News_Clustering p5 = new P5_1_News_Clustering();
        int answer = p5.solution(str1, str2);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }
}

