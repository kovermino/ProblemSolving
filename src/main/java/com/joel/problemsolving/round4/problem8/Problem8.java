package com.joel.problemsolving.round4.problem8;

/**
 * 정수와 음수를 담은 N x N 행렬이 입력으로 주어졌을 때,
 * 그 모든 원소의 합이 최대가 되는 부분 행렬을 찾는 코드를 작성하라.
 * -> 전부 순회하면서 계산 + 미리 계산된 cache 사용
 */
public class Problem8 {
    public int[][] getLargestSumMatrix(int N, int[][] matrix) {
        if(matrix.length != N || matrix[0].length != N) throw new RuntimeException("크기 N의 정사각행렬이 아닙니다");
        int[][] sumCache = getCachedValues(N, matrix);
        int maxArea = Integer.MIN_VALUE;
        int[][] result = null;
        for(int i1=0;i1<N;i1++) {
            for(int j1=0;j1<N;j1++) {
                for(int i2=0;i2<N;i2++) {
                    for(int j2=0;j2<N;j2++) {
                       int currentArea = getSum(sumCache, i1, j1, i2, j2);
                       if(maxArea < currentArea) {
                           maxArea = currentArea;
                           result = new int[][] {
                                   {i1, j1},
                                   {i2, j2}
,                           };
                       }
                    }
                }
            }
        }
        return result;
    }

    public int[][] getCachedValues(int N, int[][] matrix) {
        int[][] cache = new int[N][N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(i == 0 && j == 0) {
                    cache[i][j] = matrix[i][j];
                } else if(i == 0) {
                    cache[i][j] = cache[i][j-1] + matrix[i][j];
                } else if(j == 0) {
                    cache[i][j] = cache[i-1][j] + matrix[i][j];
                } else {
                    cache[i][j] = cache[i-1][j] + cache[i][j-1] - cache[i-1][j-1] + matrix[i][j];
                }
            }
        }
        return cache;
    }

    public int getSum(int[][] sums, int i1, int j1, int i2, int j2) {
        if(i1 == 0 && j1 == 0) return sums[i2][j2];
        if(i1 == 0) return sums[i2][j2] - sums[i2][j1-1];
        if(j1 == 0) return sums[i2][j2] - sums[i1-1][j2];
        return sums[i2][j2] - sums[i2][j1-1] - sums[i1-1][j2] + sums[i1-1][j1-1];
    }
}
