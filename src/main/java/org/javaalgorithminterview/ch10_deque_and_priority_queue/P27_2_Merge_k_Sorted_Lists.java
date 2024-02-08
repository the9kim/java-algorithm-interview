package org.javaalgorithminterview.ch10_deque_and_priority_queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P27_2_Merge_k_Sorted_Lists {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 1. Add All heads to the priority queue
     * 2. Poll an element from the priority queue
     * and add it next to the tail until the priority queue is empty
     */
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val == o2.val) {
                    return 0;
                } else if (o1.val > o2.val) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        ListNode root = new ListNode();
        ListNode tail = root;

        // 1
        for (ListNode node : lists) {
            if (node != null) {
               pq.add(node);
            }
        }

        // 2
        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;

            if (tail.next != null) {
                pq.add(tail.next);
            }
        }

        return root.next;
    }
}




