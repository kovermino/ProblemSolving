package com.joel.problemsolving.round3.problem5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TowerTest {

    private Tower sut;

    @BeforeEach
    void setUp() {
        sut = new Tower();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void build_입력된_숫자만큼_원판을_큰_순서대로_쌓는다(int diskCount) throws Exception {
        sut.build(diskCount);


        assertEquals(diskCount, sut.getDiskCount());
        for(int i=1;i<=diskCount;i++) {
            int current = sut.pop();
            assertEquals(i, current);
        }
    }

    @Test
    void pop_가장_위에_있는_원판을_꺼낸다() throws Exception {
        sut.build(2);
        int top = sut.pop();


        assertEquals(1, top);
        assertEquals(1, sut.getDiskCount());
    }

    @Test
    void isEmpty_탑이_비어있으면_True를_리턴한다() {
        assertTrue(sut.isEmpty());
    }

    @Test
    void isEmpty_탑이_비어있지_않으면_false를_리턴한다() throws Exception {
        int disk = 1;


        sut.build(disk);


        assertFalse(sut.isEmpty());
    }

    @Test
    void moveDisk_가장_위에_있는_원판빼서_target에_넣는다() throws Exception {
        Tower other = new Tower();


        sut.build(5);
        sut.moveDiskTo(other);


        assertEquals(4, sut.getDiskCount());
        assertEquals(1, other.getDiskCount());
        assertEquals(2, sut.pop());
        assertEquals(1, other.pop());
    }
}