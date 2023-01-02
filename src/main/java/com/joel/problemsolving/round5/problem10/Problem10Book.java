package com.joel.problemsolving.round5.problem10;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 여기서는 셀의 값이 0인 경우를 검정색 픽셀로 간주한다.
 *
 */
public class Problem10Book {

    @Data
    @AllArgsConstructor
    public class SquareCell {
        private int zerosRight;
        private int zerosBelow;
    }

    public int[][] findSquare(int[][] matrix) {
        SquareCell[][] processed = processSquare(matrix);
        System.out.println("processed(zeroRight, zeroBelow):");
        printSquareMatrix(processed);

        for(int i=matrix.length;i>=1;i--) {
            int[][] square = findSquareWithSize(processed, matrix, i);
            if(square != null) {
                System.out.println("solution:");
                printMatrix(square);
                return square;
            }
        }
        return null;
    }

    private SquareCell[][] processSquare(int[][] matrix) {
        SquareCell[][] processed = new SquareCell[matrix.length][matrix.length];
        for(int row= matrix.length-1;row >= 0;row--) {
            for(int col = matrix.length -1 ; col >= 0;col--) {
                int rightZeros = 0;
                int belowZeros = 0;
                if(matrix[row][col] == 1) {
                    rightZeros++;
                    belowZeros++;
                    if(col + 1 < matrix.length) {
                        SquareCell previous = processed[row][col+1];
                        rightZeros += previous.zerosRight;
                    }
                    if(row + 1 < matrix.length) {
                        SquareCell previous = processed[row+1][col];
                        belowZeros += previous.zerosBelow;
                    }
                }
                processed[row][col] = new SquareCell(rightZeros, belowZeros);
            }
        }
        return processed;
    }

    private int[][] findSquareWithSize(SquareCell[][] processed, int[][] matrix, int squareSize) {
        int count = processed.length - squareSize + 1;

        for(int row=0;row < count; row++) {
            for(int col=0;col<count;col++) {
                if(isSquare(processed, row, col, squareSize)) {
                    return extractSubSquare(row, col, squareSize, matrix);
                }
            }
        }

        return null;
    }

    private boolean isSquare(SquareCell[][] matrix, int row, int col, int size) {
        SquareCell topLeft = matrix[row][col];
        SquareCell topRight = matrix[row][col + size - 1];
        SquareCell bottomLeft = matrix[row + size -1][col];

        if(topLeft.zerosRight < size) return false;
        if(topRight.zerosBelow < size) return false;
        if(bottomLeft.zerosRight < size) return false;

        return true;
    }

    private int[][] extractSubSquare(int row, int col, int n, int[][] matrix) {
        int[][] subSquare = new int[n][n];
        int i = 0;
        int j = 0;
        for(int x = row;x<row+n;x++) {
            for(int y=col;y<col+n;y++) {
                subSquare[i][j] = matrix[x][y];
                j++;
            }
            i++;
            j=0;
        }
        return subSquare;
    }

    private void printMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix.length;j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void printSquareMatrix(SquareCell[][] matrix) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix.length;j++) {
                if(matrix[i][j] == null) {
                    System.out.print("null ");
                } else {
                    System.out.print("(" + matrix[i][j].zerosRight + ", " + matrix[i][j].zerosBelow + ") ");
                }
            }
            System.out.println();
        }
    }
}
