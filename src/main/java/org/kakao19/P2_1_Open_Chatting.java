package org.kakao19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P2_1_Open_Chatting {
    /**
     * 1. retrieve the final nickname
     * 2. generate announcement statements
     */
    public String[] solution(String[] record) {

        Map<String, String> nicknameMap = retrieveFinalNicknames(record);

        List<String> statements = generateAnnouncementStatements(record, nicknameMap);

        return statements.toArray(new String[statements.size()]);
    }

    private Map<String, String> retrieveFinalNicknames(String[] record) {

        Map<String, String> nicknameMap = new HashMap<>();

        for (String r : record) {
            String[] rSplit = r.split("\\s");
            if (rSplit[0].equals("Enter") || rSplit[0].equals("Change")) {
                nicknameMap.put(rSplit[1], rSplit[2]);
            }
        }

        return nicknameMap;
    }

    private List<String> generateAnnouncementStatements(String[] record, Map<String, String> nicknameMap) {
        List<String> statements = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            String[] rSplit = record[i].split("\\s");

            if (rSplit[0].equals("Enter")) {
                statements.add(String.format("%s님이 들어왔습니다.", nicknameMap.get(rSplit[1])));
            } else if (rSplit[0].equals("Leave")) {
                statements.add(String.format("%s님이 나갔습니다.", nicknameMap.get(rSplit[1])));
            }
        }

        return statements;
    }
}
