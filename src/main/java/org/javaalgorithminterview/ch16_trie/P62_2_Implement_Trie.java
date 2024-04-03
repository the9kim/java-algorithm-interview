package org.javaalgorithminterview.ch16_trie;


/**
 * The book solution
 *
 * This implements the containment of subsequence characters by utilizing fixed-size array,
 * typically of size 26, to represent each character in alphabet.
 *
 */
public class P62_2_Implement_Trie {

    class TrieNode {
        boolean end;
        TrieNode[] children = new TrieNode[26];
    }

    TrieNode root;

    public P62_2_Implement_Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;

        char[] chars = word.toCharArray();

        for (char w : chars) {
            if (node.children[w - 'a'] == null) {
                node.children[w - 'a'] = new TrieNode();
            }
            node = node.children[w - 'a'];
        }
        node.end = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        char[] chars = word.toCharArray();

        for (char c : chars) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }

        return node.end == true;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        char[] chars = prefix.toCharArray();

        for (char c : chars) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }

}
