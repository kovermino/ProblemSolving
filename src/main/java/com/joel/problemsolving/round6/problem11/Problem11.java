package com.joel.problemsolving.round6.problem11;

/**
 * 정수 배열이 주어졌을 때, m부터 n까지의 원소를 정렬하기만 하면 배열 전체가 정렬되는 m과 n을 찾아라.
 * n - m이 최소화 되도록 하라. (다시 말해, 그런 순열 중 가장 짧은 것을 찾아야 한다)
 * [알고리즘]
 * 1. 처음부터, 끝부터 시작해서 정렬되지 않은 첫 번째 원소들을 찾는다.
 * = left - middle - right 로 배열을 나눈다.
 * - 여기서 min(middle) < max(left) 이고, max(middle) < min(right) 를 만족하는 middle을 찾아야 함.
 * 2. 왼쪽과 오른쪽으로 하나씩 포인터를 옮기면서 조건을 만족하는 범위를 찾는다.
 */
public class Problem11 {
    public int[] findShortestSortIndices(int[] array) {
        if (array == null || array.length == 0) return new int[]{};

        int leftEndPointer = findLeftEndPointer(array);
        int rightStartPointer = findRightStartPointer(array);

        if (leftEndPointer == 0 && rightStartPointer == array.length - 1) {
            return new int[]{0, array.length - 1};
        }

        if (leftEndPointer == -1 && rightStartPointer == -1) {
            return new int[]{-1, -1};
        }

        int rightMinValue = array[rightStartPointer];
        int leftMaxValue = array[leftEndPointer];

        int middleMinValue = Integer.MAX_VALUE;
        int middleMaxValue = Integer.MIN_VALUE;
        for (int i = leftEndPointer; i <= rightStartPointer; i++) {
            int current = array[i];
            if (current < middleMinValue) {
                middleMinValue = current;
            }
            if (current > middleMaxValue) {
                middleMaxValue = current;
            }
        }

        while (middleMinValue < leftMaxValue || middleMaxValue > rightMinValue) {
            if (middleMinValue < leftMaxValue) {
                leftEndPointer--;
                leftMaxValue = array[leftEndPointer];
                if (middleMinValue > leftMaxValue) {
                    middleMinValue = leftMaxValue;
                }
            }

            if (middleMaxValue > rightMinValue) {
                rightStartPointer++;
                rightMinValue = array[rightStartPointer];
                if (middleMaxValue < rightMinValue) {
                    middleMaxValue = rightMinValue;
                }
            }
        }
        return new int[]{leftEndPointer + 1, rightStartPointer - 1};
    }

    private int findLeftEndPointer(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    private int findRightStartPointer(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] < array[i - 1]) {
                return i;
            }
        }
        return -1;
    }
}
