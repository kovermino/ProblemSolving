package com.joel.problemsolving.round5.problem9;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class Problem9Test {

    @Test
    void getConversionPath_사전에_있는_단어들로_구성된_경로를_리턴한다() {
        Set<String> dictionary = Set.of("DAMP", "LAMP", "LIMP", "LIME", "LIKE");


        Problem9 sut = new Problem9();
        List<String> path = sut.getConversionPath("DAMP", "LIKE", dictionary);


        List<String> expected = Arrays.asList("DAMP", "LAMP", "LIMP", "LIME", "LIKE");
        assertEquals(expected, path);
    }

    @Test
    void getConversionPath_경로가_구성되지_않으면_null을_리턴한다() {
        Set<String> dictionary = Set.of("DAMP", "LAMP", "LIMP", "LIKE");


        Problem9 sut = new Problem9();
        List<String> path = sut.getConversionPath("DAMP", "LIKE", dictionary);


        assertNull(path);
    }

    @Test
    void getConversionPath_start가_사전에_없으면_null을_리턴한다() {
        Set<String> dictionary = Set.of("DAMP", "LAMP", "LIMP", "LIME", "LIKE");


        Problem9 sut = new Problem9();
        List<String> path = sut.getConversionPath("DAME", "LIKE", dictionary);


        assertNull(path);
    }

    @Test
    void getConversionPath_end가_사전에_없으면_null을_리턴한다() {
        Set<String> dictionary = Set.of("DAMP", "LAMP", "LIMP", "LIME", "LIKE");


        Problem9 sut = new Problem9();
        List<String> path = sut.getConversionPath("DAMP", "LEKE", dictionary);


        assertNull(path);
    }

    @Test
    void getConversionPath_start가_end와_같으면_그_단어를_리턴한다() {
        Set<String> dictionary = Set.of("DAMP", "LAMP", "LIMP", "LIME", "LIKE");


        Problem9 sut = new Problem9();
        List<String> path = sut.getConversionPath("DAMP", "DAMP", dictionary);


        List<String> expected = Arrays.asList("DAMP");
        assertEquals(expected, path);
    }
}