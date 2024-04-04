package org.javaalgorithminterview.ch16_trie;

import java.util.ArrayList;
import java.util.List;


class TrieNode {
    int index = -1;
    TrieNode[] children = new TrieNode[26];

    List<Integer> palindrome = new ArrayList<>();
}

class Trie {
    TrieNode root = new TrieNode();

    public boolean isPalindrome(int left, int right, String word) {
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public void insert(int index, String word) {
        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--) {
            // If subsequence characters of a node is palindrome, add an index of the node to a list.
            if (isPalindrome(0, i, word)) {
                node.palindrome.add(index);
            }
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.index = index;
    }

    public List<List<Integer>> search(int index, String word) {
        List<List<Integer>> answer = new ArrayList<>();
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (node.index != -1 && isPalindrome(i, word.length() - 1, word)) {
                answer.add(List.of(index, node.index));
            }

            if (node.children[c - 'a'] == null) {
                return answer;
            }

            node = node.children[c - 'a'];
        }

        if (node.index != -1 && node.index != index) {
            answer.add(List.of(index, node.index));
        }
        for (Integer p : node.palindrome) {
            answer.add(List.of(index, p));
        }

        return answer;
    }
}

public class P63_2_Palindrome_Pairs {

    /**
     * 1. Insert a word into a Trie
     * 2. Search a pair between a word and the palindrome of the word
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> answer = new ArrayList<>();

        Trie trie = new Trie();

        for (int i = 0; i < words.length; i++) {
            trie.insert(i, words[i]);
        }

        for (int i = 0; i < words.length; i++) {
            answer.addAll(trie.search(i, words[i]));
        }

        return answer;
    }
}
