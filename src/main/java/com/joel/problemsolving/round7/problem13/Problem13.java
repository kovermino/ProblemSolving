package com.joel.problemsolving.round7.problem13;

/**
 * n개의 계단을 오른다고 가정하자. 한 번에 1계단, 2계단, 3계단을 오를 수 있다면 계단을 오르는 데 몇 가지 방법이 있는지 계산하는 메서드를 작성하라.
 * 1 = 1 (1)
 * 2 = 2 (1 + 1, 2)
 * 3 = 4 (1 + 1 + 1, 1 + 2, 2 + 1,  3)
 * 4 = SOL 3 + SOL 1 = 4
 * 5 = SOL 3 + SOL 2
 */
public class Problem13 {
    public int getSteppingMethodTotalCount(int n) {
        if(n <= 0) return -1;
        int[] cache = new int[n+1];
        return calculate(n, cache);
    }

    public int calculate(int n, int[] cache) {
        if(n < 0) {
            return 0;
        } else if(n == 0) {
            return 1;
        } else if(cache[n] > 0) {
            return cache[n];
        } else {
            cache[n] = calculate(n-1, cache) + calculate(n-2, cache) + calculate(n-3, cache);
            return cache[n];
        }
    }
}
