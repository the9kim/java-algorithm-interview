package org.javaalgorithminterview.ch16_trie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.javaalgorithminterview.ch16_trie.P62_1_Implement_Trie.Trie;

class P62_1_Implement_TrieTest {

    Trie root;
    String word;

    @BeforeEach
    void setUp() {
        root = new Trie("root");
        word = "apple";
        root.insert(word);
    }

    @Test
    void insertNonExistWord() {
        // given & when & then

        for (int i = 0; i < word.length(); i++) {
            root = getChild(root, word.substring(i, i + 1));
            assertThat(root.val).isEqualTo(word.substring(i, i + 1));
            System.out.println(root.val);
        }
    }

    @Test
    void insertExistWord() {
        // given
        String word = "app";

        // when
        root.insert(word);

        // then
        for (int i = 0; i < word.length(); i++) {
            root = getChild(root, word.substring(i, i + 1));
            assertThat(root.val).isEqualTo(word.substring(i, i + 1));
            System.out.println(root.val);
        }
    }

    @Test
    void searchExistWord() {
        // given
        String word = "apple";
        boolean expected = true;

        // when
        boolean answer = root.search(word);

        // then
        assertThat(answer).isEqualTo(expected);
    }

    @Test
    void searchNonExistWord() {
        // given
        String word = "apply";
        boolean expected = false;

        // when
        boolean answer = root.search(word);

        // then
        assertThat(answer).isEqualTo(expected);
    }

    @Test
    void searchNonExistWord2() {
        // given
        String word = "app";
        boolean expected = false;

        // when
        boolean answer = root.search(word);

        // then
        assertThat(answer).isEqualTo(expected);
    }

    @Test
    void startsWithExistWord() {
        // given
        String word = "app";
        boolean expected = true;

        // when
        boolean answer = root.startsWith(word);

        // then
        assertThat(answer).isEqualTo(expected);
    }

    @Test
    void startsWithNonExistWord() {
        // given
        String word = "apply";
        boolean expected = false;

        // when
        boolean answer = root.startsWith(word);

        // then
        assertThat(answer).isEqualTo(expected);
    }

    public Trie getChild(Trie root, String w) {
        for (Map.Entry entry : root.children.entrySet()) {
            if (entry.getKey().equals(w)) {
                return (Trie) entry.getValue();
            }
        }
        return null;
    }
}
