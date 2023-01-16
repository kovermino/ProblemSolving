package com.joel.problemsolving.round7.problem14;

/**
 * X x Y 그리드의 왼쪽 상단 꼭지점에 로봇이 놓여있다.
 * 이 로봇은 오른쪽 아니면 아래쪽으로만 이동할 수 있다.
 * 로봇이 (0,0)에서 (X,Y)로 이동하는데 있어 가능한 경로는 몇 가지가 있는지 계산하는 메서드를 작성하라.
 */
public class Problem14 {

    public int getWays(int x, int y) {
        return factorial(x+y) / (factorial(x) * factorial(y));
    }

    private int factorial(int n) {
        int result = 1;
        while(n > 1) {
            result *= n;
            n--;
        }
        return result;
    }

}
