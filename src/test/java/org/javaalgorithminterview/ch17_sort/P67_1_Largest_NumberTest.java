package org.javaalgorithminterview.ch17_sort;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class P67_1_Largest_NumberTest {

    @Test
    void largestNumber() {
        // given
        int[] nums = new int[]{3, 30, 34, 5, 9};
        String expected = "9534330";

        // when
        P67_1_Largest_Number p67 = new P67_1_Largest_Number();
        String answer = p67.largestNumber(nums);

        // then
        assertThat(answer).isEqualTo(expected);
    }

    @Test
    void integerToString() {
        // given
        int given = 30;
        String expected = "30";

        // when
        String answer = Integer.toString(given);

        // then
        assertThat(answer).isEqualTo(expected);
    }

    @Test
    void sortOneString() {
        // given
        String[] given = new String[]{"3", "4"};
        String[] expected = new String[]{"4", "3"};

        // when
        Arrays.sort(given, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                char[] o1Arr = o1.toCharArray();
                char[] o2Arr = o2.toCharArray();

                for (int i = 0; i < Math.min(o1Arr.length, o2Arr.length); i++) {
                    if (o1Arr[i] < o2Arr[i]) {
                        return 1;
                    } else if (o1Arr[i] > o2Arr[i]) {
                        return -1;
                    }
                }
                return 0;
            }
        });

        // then
        assertThat(given).isEqualTo(expected);
    }

    @Test
    void sortOneStringUsingCompareTo() {
        // given
        String[] given = new String[]{"3", "4"};
        String[] expected = new String[]{"4", "3"};

        // when
        Arrays.sort(given, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        // then
        assertThat(given).isEqualTo(expected);
    }

    @Test
    void sortStrings() {
        // given
        String[] given = new String[]{"33", "34"};
        String[] expected = new String[]{"34", "33"};

        // when
        Arrays.sort(given, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                char[] o1Arr = o1.toCharArray();
                char[] o2Arr = o2.toCharArray();

                for (int i = 0; i < Math.min(o1Arr.length, o2Arr.length); i++) {
                    if (o1Arr[i] < o2Arr[i]) {
                        return 1;
                    } else if (o1Arr[i] > o2Arr[i]) {
                        return -1;
                    }
                }
                return 0;
            }
        });

        // then
        assertThat(given).isEqualTo(expected);
    }

    @Test
    void sortStringsUsingComparator() {
        // given
        String[] given = new String[]{"33", "34"};
        String[] expected = new String[]{"34", "33"};

        // when
        Arrays.sort(given, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        // then
        assertThat(given).isEqualTo(expected);
    }

    @Test
    void sort_different_size_of_strings() {
        // given
//        String[] given = new String[]{"30", "3"};
//        String[] expected = new String[]{"3", "30"};
//        String[] given = new String[]{"3", "34"};
//        String[] expected = new String[]{"34", "3"};
        String[] given = new String[]{"30", "34", "3"};
        String[] expected = new String[]{"34", "3", "30"};

        // when
        Arrays.sort(given, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                char[] o1Arr = o1.toCharArray();
                char[] o2Arr = o2.toCharArray();

                char[] smaller = o1Arr.length < o2Arr.length ? o1Arr : o2Arr;
                char[] bigger = o1Arr.length > o2Arr.length ? o1Arr : o2Arr;


                // Comparison Condition for levels of same size
                for (int i = 0; i < smaller.length; i++) {
                    // If it follows basic sorting standard(Ascending order), it would return -1
                    // However, in this case, I want descending order, it returns 1
                    if (o1Arr[i] < o2Arr[i]) {
                        return 1;
                    } else if (o1Arr[i] > o2Arr[i]) {
                        return -1;
                    }
                }

                // Comparison Condition for the levels of different size
                char endValueSmaller = smaller[smaller.length - 1];
                char nextEndValueBigger = bigger[smaller.length];

                // The scenario where the smaller element should be positioned at the end
                if (endValueSmaller < nextEndValueBigger) {
                    if (smaller == o2Arr) {
                        return -1;
                    } else if (smaller == o1Arr) {
                        return 1;
                    }
                    // The scenario where the smaller element should be positioned at the front
                } else if (endValueSmaller > nextEndValueBigger) {
                    if (smaller == o2Arr) {
                        return 1;
                    } else if (smaller == o1Arr) {
                        return -1;
                    }
                }
                return 0;
            }
        });

        // then
        assertThat(given).isEqualTo(expected);
    }

    @Test
    void sort_different_size_of_strings_using_comparator() {
        // given
//        String[] given = new String[]{"30", "3"};
//        String[] expected = new String[]{"3", "30"};
//        String[] given = new String[]{"3", "34"};
//        String[] expected = new String[]{"34", "3"};
        String[] given = new String[]{"30", "34", "3"};
        String[] expected = new String[]{"34", "3", "30"};

        // when
        Arrays.sort(given, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                // when I place a new value at the beginning of the current value and concatenate them,
                // if the resulting combination is bigger than the opposite case,
                // I need to return 1.
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        // then
        assertThat(given).isEqualTo(expected);
    }
}
