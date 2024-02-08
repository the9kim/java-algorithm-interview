package org.javaalgorithminterview.ch6_string;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class P3_1_Reorder_Data_in_Log_FilesTest {

    @Test
    void reorderLogsFiles() {
        // given
        String[] given = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        String[] expected = {"let1 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1", "dig2 3 6"};
        P3_1_Reorder_Data_in_Log_Files p3 = new P3_1_Reorder_Data_in_Log_Files();

        // when
        String[] answer = p3.reorderLogFiles(given);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void separateLogs() {

        // given
        String[] given = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        List<List<String>> expected = List.of(
                List.of("let1", "art can"),
                List.of("let2", "own kit dig"),
                List.of("let3", "art zero"));

        // when
        List<List<String>> letterLogs = new ArrayList<>();
        List<List<String>> digitLogs = new ArrayList<>();

        for (String log : given) {
            List<String> logArr = Arrays.asList(log.split(" ", 2));
            if (Character.isLetter(logArr.get(1).charAt(0))) {
                letterLogs.add(logArr);
            } else {
                digitLogs.add(logArr);
            }
        }

        Assertions.assertThat(letterLogs).isEqualTo(expected);
    }

    @Test
    void sortLetterLogsByContentsAndByIdentifier() {

        // given
        List<List<String>> letterLogs = List.of(
                List.of("let2", "own kit dig"),
                List.of("let3", "art zero"),
                List.of("let2", "art can"),
                List.of("let1", "art can")
        );

        List<List<String>> expected = List.of(
                List.of("let1", "art can"),
                List.of("let2", "art can"),
                List.of("let3", "art zero"),
                List.of("let2", "own kit dig")
        );

        // when
        List<List<String>> sortedLogs = letterLogs.stream()
                .sorted(Comparator.comparing((List<String> logs) -> logs.get(1))
                        .thenComparing(logs -> logs.get(0)))
                .collect(Collectors.toList());
        // then
        Assertions.assertThat(sortedLogs).isEqualTo(expected);
    }

    @Test
    void joinListElementsOfLog() {
        // given
        List<List<String>> letterLogs = List.of(
                List.of("let1", "art can"),
                List.of("let2", "art can"),
                List.of("let3", "art zero"),
                List.of("let2", "own kit dig")
        );

        List<String> expectedLetterLogs = List.of(
                "let1 art can", "let2 art can", "let3 art zero", "let2 own kit dig"
        );

        List<List<String>> digitLogs = List.of(
                List.of("dig1", "8 1 5 1"),
                List.of("dig2", "3 6")
        );

        List<String> expectedDigitLogs = List.of(
                "dig1 8 1 5 1",
                "dig2 3 6"
        );

        // when
        List<String> letterStrLogs = letterLogs.stream()
                .map(log -> log.stream().collect(Collectors.joining(" ")))
                .collect(Collectors.toList());

        List<String> digitStrLogs = digitLogs.stream()
                .map(logs -> logs.stream().collect(Collectors.joining(" ")))
                .collect(Collectors.toList());

        // then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(letterStrLogs).isEqualTo(expectedLetterLogs);
            softly.assertThat(digitStrLogs).isEqualTo(expectedDigitLogs);
        });

    }

    @Test
    void combineLetterLogsWithDigitLogs() {
        // given
        List<String> letterLogs = List.of(
                "let1 art can", "let2 art can", "let3 art zero", "let2 own kit dig"
        );

        List<String> digitLogs = List.of(
                "dig1 8 1 5 1",
                "dig2 3 6"
        );

        List<String> expected = List.of(
                "let1 art can", "let2 art can", "let3 art zero", "let2 own kit dig",
                "dig1 8 1 5 1", "dig2 3 6");

        // when
        List<String> logs = new ArrayList();
        logs.addAll(letterLogs);
        logs.addAll(digitLogs);

        // then
        Assertions.assertThat(logs).isEqualTo(expected);


    }

}
