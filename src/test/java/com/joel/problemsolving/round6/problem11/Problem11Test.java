package com.joel.problemsolving.round6.problem11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem11Test {

    @Test
    void findShortestSortIndices_가장_짧은_정렬_인덱스를_찾는다() {
        int[] array = new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};


        Problem11 sut = new Problem11();
        int[] result = sut.findShortestSortIndices(array);


        assertEquals(3, result[0]);
        assertEquals(9, result[1]);
    }

    @Test
    void findShortestSortIndices_첫_middle이_없는_경우에도_가장_짧은_인덱스를_찾는다() {
        int[] array = new int[]{1, 2, 5, 7, 4, 6, 8, 9};


        Problem11 sut = new Problem11();
        int[] result = sut.findShortestSortIndices(array);


        assertEquals(2, result[0]);
        assertEquals(5, result[1]);
    }

    @Test
    void findShortestSortIndices_빈_배열이_입력되면_빈_배열을_리턴한다() {
        int[] array = new int[]{};


        Problem11 sut = new Problem11();
        int[] result = sut.findShortestSortIndices(array);


        assertEquals(0, result.length);
    }

    @Test
    void findShortestSortIndices_null이_입력되면_빈_배열을_리턴한다() {
        Problem11 sut = new Problem11();
        int[] result = sut.findShortestSortIndices(null);


        assertEquals(0, result.length);
    }

    @Test
    void findShortestSortIndices_전체를_정렬해야_하는_경우() {
        int[] array = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};


        Problem11 sut = new Problem11();
        int[] result = sut.findShortestSortIndices(array);


        assertEquals(0, result[0]);
        assertEquals(8, result[1]);
    }

    @Test
    void findShortestSortIndices_정렬을_안해도_되는_경우() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};


        Problem11 sut = new Problem11();
        int[] result = sut.findShortestSortIndices(array);


        assertEquals(-1, result[0]);
        assertEquals(-1, result[1]);
    }
}