package com.joel.problemsolving.round5.problem10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem10BookBookTest {
    @Test
    void findSquare_가장_큰_검정색_테두리의_부분행렬을_찾는다() {
        int[][] matrix = new int[][]{
                {0, 0, 1, 1, 1, 1},
                {0, 0, 1, 1, 0, 1},
                {0, 0, 1, 1, 0, 1},
                {0, 0, 1, 1, 1, 1},
                {0, 0, 1, 1, 0, 1},
                {0, 0, 1, 1, 0, 1}
        };


        Problem10Book sut = new Problem10Book();
        int[][] result = sut.findSquare(matrix);


        int[][] expected = new int[][]{
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1}
        };
        assertArrayEquals(expected, result);
    }

    @Test
    void findSquare_답이_주어진_행렬_그_자체인_케이스() {
        int[][] matrix = new int[][]{
                {1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1}
        };


        Problem10Book sut = new Problem10Book();
        int[][] result = sut.findSquare(matrix);


        int[][] expected = new int[][]{
                {1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1}
        };
        assertArrayEquals(expected, result);
    }

    @Test
    void findSquare_검은색_픽셀이_1개뿐인_케이스() {
        int[][] matrix = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
        };


        Problem10Book sut = new Problem10Book();
        int[][] result = sut.findSquare(matrix);


        int[][] expected = new int[][]{
                {1}
        };
        assertArrayEquals(expected, result);
    }

}