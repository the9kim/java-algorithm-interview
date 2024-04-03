package org.javaalgorithminterview.ch16_trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P62_1_Implement_Trie {

    static class Trie {

        String val = "root";

        Map<String, Trie> children = new HashMap<>();

        boolean end;


        public Trie() {

        }

        public Trie(String val) {
            this.val = val;
        }

        public void insert(String word) {

            // Indicate this node as the end of the word
            if (!val.equals("root") && word.length() == 0) {
                end = true;
            }

            // Register the first character to the children Map and repeat this process using recursive DFS
            if (word.length() > 0) {
                word = word.toLowerCase();
                String first = word.substring(0, 1);

                Trie trie = children.getOrDefault(first, new Trie(first));
                children.put(first, trie);
                trie.insert(word.substring(1, word.length()));
            }
        }

        public boolean search(String word) {

            // check if this trie node is an end node and the value of the node is the last character of the word
            if (word.length() == 0 && end == true) {
                return true;
            } else if (word.length() == 0 && end == false) {
                return false;
            }

            // Check if this node contains the first character of the word and repeat this process using recursive DFS
            Trie child = children.get(word.substring(0, 1));
            if (child == null) {
                return false;
            }

            if (child.search(word.substring(1, word.length()))) {
                return true;
            }
            return false;
        }

        public boolean startsWith(String prefix) {
            // check if this trie node is an end node
            if (prefix.length() == 0) {
                return true;
            }

            // Check if this node contains the first character of the prefix and repeat this process using recursive DFS
            Trie child = children.get(prefix.substring(0, 1));
            if (child == null) {
                return false;
            }
            if (!child.startsWith(prefix.substring(1, prefix.length()))) {
                return false;
            }
            return true;
        }
    }
}
