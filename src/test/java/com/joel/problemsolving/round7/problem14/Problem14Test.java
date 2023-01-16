package com.joel.problemsolving.round7.problem14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem14Test {

    @Test
    void 원점만_있으면_1을_리턴한다() {
        Problem14 sut = new Problem14();


        int result = sut.getWays(0, 0);


        assertEquals(1, result);
    }

    @Test
    void 크기가_4인_정사각형의_경우에는_6을_리턴한다() {
        Problem14 sut = new Problem14();


        int result = sut.getWays(2, 2);


        assertEquals(6, result);
    }

    @Test
    void 크기가_9인_정사각형의_경우에는_20을_리턴한다() {
        Problem14 sut = new Problem14();


        int result = sut.getWays(3, 3);


        assertEquals(20, result);
    }
}