package org.javaalgorithminterview.ch16_trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P63_1_Palindrome_Pairs {
    public class TrieNode {
        boolean end;
        TrieNode[] children = new TrieNode[26];
    }

    TrieNode root = new TrieNode();

    /**
     * 1. Create a Trie
     * 2. Search a reversed sub-string and check if it is palindrome
     * 3. find palindrome pais
     */

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.end = true;
    }

    public boolean search(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.end == true;
    }

    public boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> pairs = new ArrayList<>();

        List<String> wordsList = Arrays.asList(words);
        // 1
        for (int i = 0; i < wordsList.size(); i++) {
            List<List<Integer>> answer = new ArrayList<>();
            String word = wordsList.get(i);
            insert(word);
            String reversed = new StringBuilder(word).reverse().toString();

            if (!isPalindrome(word) && search(reversed)) {
                answer.add(List.of(i, wordsList.indexOf(reversed)));
            }

            if (reversed.length() <= 1) {
                continue;
            }

            String rightSub = reversed.substring(1, reversed.length());
            if (search(rightSub)) {
                answer.add(List.of(i, wordsList.indexOf(rightSub)));

                if (isPalindrome(rightSub) && search(reversed.substring(0, 1))) {
                    answer.add(List.of(wordsList.indexOf(reversed.substring(0, 1)), i));
                }
            }

            String leftSub = reversed.substring(0, reversed.length() - 1);
            if (search(leftSub)) {
                answer.add(List.of(wordsList.indexOf(leftSub), i));

                if (isPalindrome(leftSub) && search(reversed.substring(reversed.length() - 1, reversed.length()))) {
                    answer.add(List.of(i, wordsList.indexOf(reversed.substring(reversed.length() - 1, reversed.length()))));
                }
            }
            pairs.addAll(answer);
        }

        return pairs;
    }
}
