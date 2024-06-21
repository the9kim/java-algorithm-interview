package org.kakao21;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class P5_1_Advertise_InsertionTest {

    @Test
    void advInsertion() {
        // given
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};

        String expected = "01:30:59";

        // when
        P5_1_Advertise_Insertion p5 = new P5_1_Advertise_Insertion();
        String answer = p5.solution(play_time, adv_time, logs);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void advInsertion2() {
        // given
        String play_time = "00:00:15";
        String adv_time = "00:00:03";
        String[] logs = {"00:00:00-00:00:03", "00:00:02-00:00:05", "00:00:04-00:00:07"};

        String expected = "00:00:02";

        // when
        P5_1_Advertise_Insertion p5 = new P5_1_Advertise_Insertion();
        String answer = p5.solution(play_time, adv_time, logs);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void duration() {
        Duration play = Duration.ofHours(0)
                .plusMinutes(0)
                .plusSeconds(15);

        Duration adv = Duration.ofHours(0)
                .plusMinutes(0)
                .plusSeconds(2);

        for (int i = 1; i <= play.getSeconds() - adv.getSeconds(); i++) {
            System.out.println(i);
        }

    }
}
