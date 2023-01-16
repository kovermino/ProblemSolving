package com.joel.problemsolving.round6.problem12;

/**
 * 정수 배열이 주어진다(이 배열에는 양수와 음수가 모두 허용된다).
 * 가장 큰 합을 갖는 연속 수열을 찾고 그 합을 반환하는 함수를 작성하라.
 * 예:
 * 입력: 2, -8, 3, -2, 4, -10
 * 출력: 15(= {3, -2, 4}의 합)
 */
public class Problem12 {
    public int getLargestSum(int[] array) {
        boolean isAllMinus = false;
        int sum = 0;
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sum < 0) {
                sum = 0;
            } else if (max < sum) {
                max = sum;
            }
        }
        return max;
    }
}
