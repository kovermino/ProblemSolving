package com.joel.problemsolving.round4.problem7;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Problem7Test {

    @Test
    void findLongestCombinedWord_조합단어가_하나_있을때_가장_긴_조합단어를_찾는다() {
        String[] words = new String[] {"cat", "banana", "dog", "nana", "walk", "walker", "dogwalker"};


        Problem7 sut = new Problem7();


        assertEquals("dogwalker", sut.findLongestCombinedWord(words));
    }

    @Test
    void findLongestCombinedWord_조합단어가_여러_개_있을때_가장_긴_조합단어를_찾는다() {
        String[] words = new String[] {"cat", "banana", "dog", "catwalk", "nana", "walk", "walker", "dogwalker"};


        Problem7 sut = new Problem7();


        assertEquals("dogwalker", sut.findLongestCombinedWord(words));
    }

    @Test
    void findLongestCombinedWord_3개를_조합한_단어가_있을때_가장_긴_조합단어를_찾는다() {
        String[] words = new String[] {"cat", "banana", "bananadogwalker", "dog", "catwalk", "nana", "walk", "walker", "dogwalker"};


        Problem7 sut = new Problem7();


        assertEquals("bananadogwalker", sut.findLongestCombinedWord(words));
    }

    @Test
    void findLongestCombinedWord_4개를_조합한_단어가_있을때_가장_긴_조합단어를_찾는다() {
        String[] words = new String[] {"cat", "banana", "bananadogwalkernana", "dog", "catwalk", "nana", "walk", "walker", "dogwalker"};


        Problem7 sut = new Problem7();


        assertEquals("bananadogwalkernana", sut.findLongestCombinedWord(words));
    }
}