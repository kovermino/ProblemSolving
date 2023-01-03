package com.joel.problemsolving.round5.problem10;

/**
 * 정방형의 행렬이 있다. 이 행렬의 각 셀(픽셀)은 검정색이거나 흰색이다.
 * 네 가장자리가 전부 검정 픽셀인 최대 부분 정방행렬을 찾는 알고리즘을 설계하고 구현하라.
 */
public class Problem10 {
    public int[][] getLargestBlackEdgeSubSquare(int[][] matrix) {
        if (matrix.length != matrix[0].length) throw new RuntimeException("정방행렬이 아닙니다");
        if (hasAllBlackSurrounding(0, 0, 6, matrix)) return matrix;

        int n = matrix.length;
        while (n > 0) {
            int range = matrix.length - n;
            for (int i = 0; i <= range; i++) {
                for (int j = 0; j <= range; j++) {
                    if (hasAllBlackSurrounding(i, j, n, matrix)) {
                        return extractSubSquare(i, j, n, matrix);
                    }
                }
            }
            n--;
        }
        return null;
    }

    private boolean hasAllBlackSurrounding(int row, int col, int n, int[][] matrix) {
        for (int i = 0; i < n; i++) {
            if (matrix[row + i][col] != 1) return false;
            if (matrix[row][col + i] != 1) return false;
            if (matrix[row + n - 1][col + i] != 1) return false;
            if (matrix[row + i][col + n - 1] != 1) return false;
        }
        return true;
    }

    private int[][] extractSubSquare(int row, int col, int n, int[][] matrix) {
        int[][] subSquare = new int[n][n];
        int i = 0;
        int j = 0;
        for (int x = row; x < row + n; x++) {
            for (int y = col; y < col + n; y++) {
                subSquare[i][j] = matrix[x][y];
                j++;
            }
            i++;
            j = 0;
        }
        return subSquare;
    }
}
