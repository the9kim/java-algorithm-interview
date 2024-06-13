package org.kakao20;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Using Trie
 *
 * 1. Create forward and backward Tries for the word using input words based on their length
 * 2. Search Tries using the queries.
 * If a query starts with a wildcard, Search the backward Trie.
 * But if a query ends with a wildcard, search the forward Trie
 */

public class P4_2_Searching_Lyrics {

    static class TrieNode {
        TrieNode[] children;
        int count;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.count = 0;
        }
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                cur.count++;
                int index = c - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            cur.count++;
        }

        public int search(String word) {
            TrieNode cur = root;

            for (char c : word.toCharArray()) {
                if (c == '?') {
                    return cur.count;
                }

                int index = c - 'a';

                if (cur.children[index] == null) {
                    return 0;
                }

                cur = cur.children[index];
            }
            return cur.count;
        }
    }

    Trie[] forward = new Trie[10000];
    Trie[] backward = new Trie[10000];


    public int[] solution(String[] words, String[] queries) {

        // 1.
        for (String word : words) {
            if (forward[word.length() - 1] == null) {
                forward[word.length() - 1] = new Trie();
                backward[word.length() - 1] = new Trie();
            }
            forward[word.length() - 1].insert(word);
            backward[word.length() - 1].insert(new StringBuilder(word).reverse().toString());
        }

        // 2.
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int index = query.length() - 1;

            if (forward[index] == null) {
                answer[i] = 0;
                continue;
            }

            if (query.endsWith("?")) {
                Trie trie = forward[query.length() - 1];
                answer[i] = trie.search(query);
            } else {
                Trie retrie = backward[query.length() - 1];
                answer[i] = retrie.search(new StringBuilder(query).reverse().toString());
            }
        }

        return answer;
    }
}
