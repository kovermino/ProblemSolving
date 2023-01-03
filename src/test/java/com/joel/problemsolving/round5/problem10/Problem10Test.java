package com.joel.problemsolving.round5.problem10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem10Test {

    @Test
    void getLargestBlackEdgeSubSquare_가장_큰_검정색_테두리의_부분행렬을_찾는다() {
        int[][] matrix = new int[][]{
                {0, 0, 1, 1, 1, 1},
                {0, 0, 1, 1, 0, 1},
                {0, 0, 1, 1, 0, 1},
                {0, 0, 1, 1, 1, 1},
                {0, 0, 1, 1, 0, 1},
                {0, 0, 1, 1, 0, 1}
        };


        Problem10 sut = new Problem10();
        int[][] result = sut.getLargestBlackEdgeSubSquare(matrix);


        int[][] expected = new int[][]{
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1}
        };
        assertArrayEquals(expected, result);
    }

    @Test
    void getLargestBlackEdgeSubSquare_답이_주어진_행렬_그_자체인_케이스() {
        int[][] matrix = new int[][]{
                {1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1}
        };


        Problem10 sut = new Problem10();
        int[][] result = sut.getLargestBlackEdgeSubSquare(matrix);


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
    void getLargestBlackEdgeSubSquare_검은색_픽셀이_1개뿐인_케이스() {
        int[][] matrix = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
        };


        Problem10 sut = new Problem10();
        int[][] result = sut.getLargestBlackEdgeSubSquare(matrix);


        int[][] expected = new int[][]{
                {1}
        };
        assertArrayEquals(expected, result);
    }
}