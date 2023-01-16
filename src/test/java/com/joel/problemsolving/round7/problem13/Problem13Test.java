package com.joel.problemsolving.round7.problem13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem13Test {
    @Test
    void 해답1() {
        Problem13 sut = new Problem13();


        int result = sut.getSteppingMethodTotalCount(1);


        assertEquals(1, result);
    }

    @Test
    void 해답2() {
        Problem13 sut = new Problem13();


        int result = sut.getSteppingMethodTotalCount(2);


        assertEquals(2, result);
    }

    @Test
    void 해답3() {
        Problem13 sut = new Problem13();


        int result = sut.getSteppingMethodTotalCount(3);


        assertEquals(4, result);
    }

    @Test
    void 해답4() {
        Problem13 sut = new Problem13();


        int result = sut.getSteppingMethodTotalCount(4);


        assertEquals(7, result);
    }

    @Test
    void 해답5() {
        Problem13 sut = new Problem13();


        int result = sut.getSteppingMethodTotalCount(5);


        assertEquals(13, result);
    }

    @Test
    void 해답6() {
        Problem13 sut = new Problem13();


        int result = sut.getSteppingMethodTotalCount(6);


        assertEquals(24, result);
    }

    @Test
    void 해답7() {
        Problem13 sut = new Problem13();


        int result = sut.getSteppingMethodTotalCount(7);


        assertEquals(44, result);
    }

    @Test
    void 큰_수_테스트() {
        Problem13 sut = new Problem13();


        int result = sut.getSteppingMethodTotalCount(10);


        assertEquals(274, result);
    }
}