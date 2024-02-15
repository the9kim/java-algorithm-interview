package org.javaalgorithminterview.ch11_hash_table;

/**
 * 1. Create Hash method.
 * 2. Make an Array list to store hashes.
 * 3. Generate a hash using the hash method and convert it into a linked list to append it to the array list
 */
public class P30_1_Design_HashMap {

    static class ListNode {
        int key;
        int val;
        ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public ListNode(int key, int val, ListNode next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    private ListNode[] hashTable;

    public P30_1_Design_HashMap() {
        hashTable = new ListNode[23];
    }

    public void put(int key, int value) {
        int hash = hash(key);
        ListNode node = new ListNode(key, value);
        ListNode root = hashTable[hash];

        if (root == null) {
            hashTable[hash] = node;
        } else {
            ListNode prev = root;
            ListNode crnt = root.next;
            if (prev.key == key) {
                prev.val = value;
                return;
            }
            while (crnt != null) {
                if (crnt.key == key) {
                    crnt.val = value;
                    // Is there any problem if there is no early return?
                    // Yes, there is a possibility that the new node would be inserted at the end of the linked list.
                    return;
                }
                prev = prev.next;
                crnt = crnt.next;
            }
            prev.next = node;
        }
    }

    public int get(int key) {
        int hash = hash(key);

        ListNode node = hashTable[hash];

        while (node != null) {
            if (node.key == key) {
                return node.val;
            }
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);

        ListNode root = hashTable[hash];
        if (root == null) {
            return;
        } else {
            if (root.key == key) {
                hashTable[hash] = root.next;
                return;
            }
            ListNode prev = root;
            ListNode node = root.next;
            while (node != null) {
                if (node.key == key) {
                    prev.next = node.next;
                    return;
                }
                prev = prev.next;
                node = node.next;
            }
        }
    }

    private int hash(int key) {
        return key % 23;
    }
}
