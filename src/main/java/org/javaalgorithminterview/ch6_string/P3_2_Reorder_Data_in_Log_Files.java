package org.javaalgorithminterview.ch6_string;

import java.util.ArrayList;
import java.util.List;

public class P3_2_Reorder_Data_in_Log_Files {

    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            String[] split = log.split(" ", 2);
            if (Character.isLetter(split[1].charAt(0))) {
                letterLogs.add(log);
            } else {
                digitLogs.add(log);
            }
        }

        letterLogs.sort((a, b) -> {
            String[] splitA = a.split(" ", 2);
            String[] splitB = b.split(" ", 2);

            int contentComparison = splitA[1].compareTo(splitB[1]);

            if (contentComparison != 0) {
                return contentComparison;
            }

            return splitA[0].compareTo(splitB[0]);
        });


        letterLogs.addAll(digitLogs);

        return letterLogs.toArray(new String[letterLogs.size()]);
    }

}
