package org.kakao19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P2_1_Open_Chatting {
    /**
     * 1. Create a nickname map
     * 2. make an answer statement using printf()
     */
    public String[] solution(String[] record) {

        // 1.
        Map<String, String> nicknameMap = new HashMap<>();

        for (String r : record) {
            String[] rArr = r.split("\\s+");

            if (rArr[0].equals("Enter")) {
                nicknameMap.put(rArr[1], rArr[2]);
            } else if (rArr[0].equals("Change")) {
                nicknameMap.put(rArr[1], rArr[2]);
            }
        }

        // 2.
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            String[] rArr = record[i].split("\\s+");

            if (rArr[0].equals("Enter")) {
                answer.add(String.format("%s님이 들어왔습니다.", nicknameMap.get(rArr[1])));
            } else if (rArr[0].equals("Leave")) {
                answer.add(String.format("%s님이 나갔습니다.", nicknameMap.get(rArr[1])));
            }
        }
        return answer.toArray(new String[1]);
    }
}
