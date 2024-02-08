package org.javaalgorithminterview.ch10_deque_and_priority_queue;

public class P27_1_Merge_k_Sorted_Lists {
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
     * 1. Utilize For-Iteration for the input Array
     * 2. Utilize While-Iteration for each ListNode in the input Array
     * 3. Extract the Node and add it to the answer node,maintaining sorted order.
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // Exception handling about the null input
        if (lists == null) {
            return null;
        }

        ListNode answer = new ListNode();

        // 1
        for (ListNode listNode : lists) {
            // Exception handling about a null element in the input array
            if (listNode == null) {
                continue;
            }
            // 2
            ListNode listcrnt = listNode;
            do {
                ListNode next = listcrnt.next;
                answer = addNode(answer, listcrnt);
                listcrnt = next;
            } while (listcrnt != null);
        }
        return answer.next;
    }

    public ListNode addNode(ListNode answerHead, ListNode newNode) {
        ListNode crnt = answerHead;

        while (crnt.next != null && crnt.next.val < newNode.val) {
            crnt = crnt.next;
        }
        newNode.next = crnt.next;
        crnt.next = newNode;

        return answerHead;
    }

}
