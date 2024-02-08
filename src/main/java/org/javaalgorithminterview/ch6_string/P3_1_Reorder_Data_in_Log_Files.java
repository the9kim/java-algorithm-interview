package org.javaalgorithminterview.ch6_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P3_1_Reorder_Data_in_Log_Files {

    /**
     * 1. sort logs(letter-logs first, digit-logs next)
     * 2. sort letter-logs lexicographically by their contents then sort them lexicographically by their identifier;
     * 3. maintain their relative ordering of digit-logs
     */
    public String[] reorderLogFiles(String[] logs) {

        // 1. separate logs
        List<List<String>> letterLogs = new ArrayList<>();
        List<List<String>> digitLogs = new ArrayList<>();

        for (String log : logs) {
            List<String> logArr = Arrays.asList(log.split(" ", 2));
            if (Character.isLetter(logArr.get(1).charAt(0))) {
                letterLogs.add(logArr);
            } else {
                digitLogs.add(logArr);
            }
        }

        // 2. sort letter-logs
        List<List<String>> sortedLetterLogs = letterLogs.stream()
                .sorted(Comparator.comparing((List<String> log) -> log.get(1))
                        .thenComparing(log -> log.get(0)))
                .collect(Collectors.toList());


        // 3. joinListElementsOfLog
        List<String> letterStrLogs = sortedLetterLogs.stream()
                .map(log -> log.stream().collect(Collectors.joining(" ")))
                .collect(Collectors.toList());

        List<String> digitStrLogs = digitLogs.stream()
                .map(log -> log.stream().collect(Collectors.joining(" ")))
                .collect(Collectors.toList());


        // 4. combine letterLogs with digitLogs
        letterStrLogs.addAll(digitStrLogs);

        return letterStrLogs.toArray(new String[0]);
    }

    /**
     * A solution that the book suggests
     */
    public String[] reorderLogFiles2(String[] logs) {

        // 1. separate Logs
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            if (Character.isLetter(log.split(" ")[1].charAt(0))) {
                letterLogs.add(log);
            } else {
                digitLogs.add(log);
            }
        }

        // 2. sort letter Logs
        Collections.sort(letterLogs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] s1Arr = s1.split(" ", 2);
                String[] s2Arr = s2.split(" ", 2);

                int compared = s1Arr[1].compareTo(s2Arr[1]);

                if (compared == 0) {
                    return s1Arr[0].compareTo(s2Arr[0]);
                } else {
                    return compared;
                }
            }
        });

        // 3. combine letter logs and digit logs
        letterLogs.addAll(digitLogs);

        // 4. change list to array and return it
        return letterLogs.toArray(new String[0]);
    }
}
