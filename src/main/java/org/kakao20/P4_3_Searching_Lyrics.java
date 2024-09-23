package org.kakao20;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P4_3_Searching_Lyrics {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        Map<Integer, Integer> count = new HashMap<>();
    }

    static class Trie {
        TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode node = root;
            int length = word.length();

            for (char c : word.toCharArray()) {
                int index = c - 'a';

                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node.count.put(length, node.count.getOrDefault(length, 0) + 1);
                length--;
                node = node.children[index];
            }
        }

        public int search(String query) {
            TrieNode node = root;
            int wildcardCount = 0;

            for (char c : query.toCharArray()) {
                if (c == '?') {
                    wildcardCount++;
                    continue;
                }

                int index = c - 'a';

                if (node.children[index] == null) {
                    return 0;
                }
                node = node.children[index];
            }

            return node.count.getOrDefault(wildcardCount, 0);
        }
    }

    public int[] solution(String[] words, String[] queries) {

        Trie trie = new Trie();
        Trie reversedTrie = new Trie();

        insertWords(words, trie, reversedTrie);

        List<Integer> freqs = retrieveWords(queries, trie, reversedTrie);

        return freqs.stream().mapToInt(Integer::intValue).toArray();
    }

    private void insertWords(String[] words, Trie trie, Trie reversedTrie) {
        for (String word : words) {
            trie.insert(word);
            reversedTrie.insert(new StringBuilder(word).reverse().toString());
        }
    }

    private List<Integer> retrieveWords(String[] queries, Trie trie, Trie reversedTrie) {
        List<Integer> freqs = new ArrayList<>();

        for (String query : queries) {
            if (query.endsWith("?")) {
                freqs.add(trie.search(query));
            } else {
                freqs.add(reversedTrie.search(new StringBuilder(query).reverse().toString()));
            }
        }

        return freqs;
    }

}
