package org.javaalgorithminterview.ch17_sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * The solution using Comparator
 */
public class P67_1_Largest_Number {

    public String largestNumber(int[] nums) {
        String answer = Arrays.stream(nums)
                .mapToObj(Integer::toString)
                .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                .collect(Collectors.joining(""));

        if ("0".repeat(answer.length()).equals(answer)) {
            return "0";
        }
        return answer;
    }
}
