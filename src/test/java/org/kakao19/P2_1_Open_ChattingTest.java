package org.kakao19;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P2_1_Open_ChattingTest {

    @Test
    void openChatting() {
        // given
        String[] record = new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        String[] expected = new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."};

        // when
        P2_1_Open_Chatting p2 = new P2_1_Open_Chatting();
        String[] answer = p2.solution(record);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }
}
