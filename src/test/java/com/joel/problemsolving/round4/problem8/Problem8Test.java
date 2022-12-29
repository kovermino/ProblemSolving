package com.joel.problemsolving.round4.problem8;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Problem8Test {

    @Test
    void getCachedValues_원점으로부터의_넓이가_계산된_배열을_리턴한다() {
        int[][] matrix = new int[][] {
                {1, 2, 3, 4},
                {-1, 1, -1, 1},
                {5, 6, 7, 8},
                {-2, -3, -4, -5}
        };


        Problem8 sut = new Problem8();
        int[][] expected = new int[][] {
                {1, 3, 6, 10},
                {0, 3, 5, 10},
                {5, 14, 23, 36},
                {3, 9, 14, 22}
        };


        assertArrayEquals(expected, sut.getCachedValues(4, matrix));
    }

    @ParameterizedTest
    @MethodSource(value = "getSumSubArrayIndexAndSum")
    void getSum_주어진_위치의_부분행렬의_합을_구한다(int i1, int j1, int i2, int j2, int sum) {
        int[][] sums = new int[][] {
                {1, 3, 6, 10},
                {0, 3, 5, 10},
                {5, 14, 23, 36},
                {3, 9, 14, 22}
        };


        Problem8 sut = new Problem8();


        assertEquals(sum, sut.getSum(sums, i1, j1, i2, j2));
    }

    @Test
    void getLargestSumMatrix_행렬에서_가장_합이_큰_부분행렬을_찾는다() {
        int[][] matrix = new int[][] {
                {1, 2, 3, 4},
                {-1, 1, -1, 1},
                {5, 6, 7, 8},
                {-2, -3, -4, -5}
        };


        Problem8 sut = new Problem8();
        int[][] expected = new int[][] {
                {0, 0},
                {2, 3}
        };

        assertArrayEquals(expected, sut.getLargestSumMatrix(4, matrix));
    }

    private static Stream<Arguments> getSumSubArrayIndexAndSum() {
        return Stream.of(
                arguments(0, 0, 0, 0, 1),
                arguments(0, 0, 0, 2, 6),
                arguments(0, 0, 2, 0, 5),
                arguments(0, 0, 2, 2, 23),
                arguments(0, 1, 2, 2, 18),
                arguments(1, 0, 2, 2, 17),
                arguments(1, 1, 3, 3, 10)
        );
    }
}