package org.javaalgorithminterview.ch11_hash_table;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.Comparator;

class P33_1_Top_K_Frequent_ElementsTest {

    @Test
    void tokKElement() {
        // given
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        // when
        P33_1_Top_K_Frequent_Elements p33 = new P33_1_Top_K_Frequent_Elements();
        int[] answer = p33.topKElement2(nums, k);
        
        // then
        SoftAssertions.assertSoftly(softly ->{
            softly.assertThat(answer[0]).isEqualTo(1);
            softly.assertThat(answer[1]).isEqualTo(2);
            
        });
        
    }

    @Test
    void sort_HashMap_Using_Entry_Set() {
        // given
        Map<Integer, Integer> freqs = new HashMap<>();
        freqs.put(1, 3);
        freqs.put(2, 2);
        freqs.put(3, 1);

        // when
        List<Map.Entry<Integer, Integer>> listEntry = new ArrayList<>(freqs.entrySet());
        listEntry.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());


        // then
        for (int i = 0; i < 2; i++) {
            System.out.println(listEntry.get(i));
        }
    }

    @Test
    void sort_List() {
        // given
        List<Integer> lst = new ArrayList<>(List.of(3, 1, 2));

        // when
        lst.sort((a, b) -> b - a);

        // then
        for (int i = 0; i < lst.size(); i++) {
            System.out.println(lst.get(i));
        }
    }

    @Test
    void sort_List_List_With_Natural_Order() {
        // given
        List<List<Integer>> outLst = new ArrayList<>();
        outLst.add(new ArrayList(List.of(2, 3, 1)));
        outLst.add(new ArrayList(List.of(5, 6, 4)));
        outLst.add(new ArrayList(List.of(8, 9, 7)));


        // when
        List<List<Integer>> sortedLists = outLst.stream()
                .map(lst -> {
                    List<Integer> sortedList = new ArrayList<>(lst);
                    sortedList.sort(Comparator.naturalOrder());
                    return sortedList;
                })
                .collect(Collectors.toList());


        // then
        System.out.println(outLst);
        System.out.println("=====");
        System.out.println(sortedLists);
    }

    @Test
    void sort_List_List_With_Reverse_Order() {
        // given
        List<List<Integer>> outLst = new ArrayList<>();
        outLst.add(new ArrayList(List.of(2, 3, 1)));
        outLst.add(new ArrayList(List.of(5, 6, 4)));
        outLst.add(new ArrayList(List.of(8, 9, 7)));


        // when
        List<List<Integer>> sortedLists = outLst.stream()
                .map(lst -> {
                    List<Integer> sortedList = new ArrayList<>(lst);
                    sortedList.sort(Comparator.reverseOrder());
                    return sortedList;
                })
                .collect(Collectors.toList());


        // then
        System.out.println(outLst);
        System.out.println("=====");
        System.out.println(sortedLists);
    }

    @Test
    void sort_HashMap_Using_PriorityQueue() {
        // given
        Map<Integer, Integer> freqs = new HashMap<>();
        freqs.put(1, 3);
        freqs.put(2, 2);
        freqs.put(3, 1);

        // when
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    if (o1[1] > o2[1]) {
                        return -1;
                    } else if (o1[1] < o2[1]) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
        );

        for (Integer key : freqs.keySet()) {
            int[] e = new int[]{key, freqs.get(key)};
            pq.add(e);
        }

        // then
        for (int i = 0; i < 2; i++) {
            System.out.println(pq.poll()[0]);
        }
    }

    @Test
    void sort_HashMap_Using_PriorityQueue2() {
        // given
        Map<Integer, Integer> freqs = new HashMap<>();
        freqs.put(1, 3);
        freqs.put(2, 2);
        freqs.put(3, 1);

        // when
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (Integer key : freqs.keySet()) {
            int[] e = new int[]{key, freqs.get(key)};
            pq.add(e);
        }

        // then
        for (int i = 0; i < 2; i++) {
            System.out.println(pq.poll()[0]);
        }
    }
}
