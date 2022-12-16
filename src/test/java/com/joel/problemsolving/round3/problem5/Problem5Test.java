package com.joel.problemsolving.round3.problem5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Problem5Test {

    private Problem5 sut;

    @BeforeEach
    void setUp() {
        sut = new Problem5();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void moveAllDisks_from의_원판들을_to로_크기가_큰_판이_아래로_가도록_옮긴다(int diskCount) throws Exception {
        Tower from = new Tower(diskCount);
        Tower to = new Tower();


        sut.moveAllDisks(from, to);


        assertEquals(diskCount, to.getDiskCount(), "n개의 원판이 to로 옮겨져야 합니다.");
        assertEquals(0, from.getDiskCount(), "from에는 원판이 없어야 합니다.");
        for(int i=1;i<=diskCount;i++) {
            int current = to.pop();
            assertEquals(i, current, i + "번째 원판의 크기가 잘못됐습니다 => " + current);
        }
    }
}