package com.joel.problemsolving.round6.problem12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem12Test {

    @Test
    void getLargestSum_가장_큰_부분수열의_합을_리턴한다() {
        int[] array = new int[]{2, -8, 3, -2, 4, -10};


        Problem12 sut = new Problem12();
        int result = sut.getLargestSum(array);


        assertEquals(5, result);
    }

    @Test
    void getLargestSum_음수로만_이루어진_배열의_경우에는_0을_리턴한다() {
        int[] array = new int[]{-2, -8, -3, -10};


        Problem12 sut = new Problem12();
        int result = sut.getLargestSum(array);


        assertEquals(0, result);
    }

    @Test
    void getLargestSum_양수로만_이루어진_배열의_경우에는_전체_합을_리턴한다() {
        int[] array = new int[]{2, 8, 3, 10};


        Problem12 sut = new Problem12();
        int result = sut.getLargestSum(array);


        assertEquals(23, result);
    }

    @Test
    void getLargestSum_양수_하나로만_이루어진_배열에_대해서는_그_하나를_리턴한다() {
        int[] array = new int[]{8};


        Problem12 sut = new Problem12();
        int result = sut.getLargestSum(array);


        assertEquals(8, result);
    }

    @Test
    void getLargestSum_음수_하나로만_이루어진_배열에_대해서는_0을_리턴한다() {
        int[] array = new int[]{-8};


        Problem12 sut = new Problem12();
        int result = sut.getLargestSum(array);


        assertEquals(0, result);
    }
}