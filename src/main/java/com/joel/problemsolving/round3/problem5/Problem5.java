package com.joel.problemsolving.round3.problem5;

/**
 * 유명한 하노이의 탑 문제에는 3개의 탑과 N개의 원판이 등장하는데, 각 원판은 어느 탑으로도 옮길 수 있다. 하노이 탑 퍼즐은 3개의 탑 가운데 하나에 이 N개의 원판을 쌓아두고 시작한다. 이때 원판들은 지름이 작은 원판이 위로 오도록 배열된다. 하노이 탑 퍼즐에는 다음과 같은 제약조건들이 있다.
 *  - 한 번에 하나의 원판만을 옮길 수 있다.
 *  - 탑의 맨 꼭대기에 있는 원판은 옆에 있는 탑으로 옮길 수 있다.
 *  - 원판은 자기보다 지름이 큰 원판 위로만 옮길 수 있다.
 * 첫 번째 탑에 있는 모든 원판을 마지막 탑으로 옮기는 알고리즘을 작성하라.
 */
public class Problem5 {

    public void moveAllDisks(Tower from, Tower to) throws Exception {
        int n = from.getDiskCount();
        Tower buffer = new Tower();
        moveDisks(n, from, to, buffer);
    }

    private void moveDisks(int n, Tower from, Tower to, Tower buffer) throws Exception {
        if(n == 1) {
            from.moveDiskTo(to);
        } else if(n == 2) {
            from.moveDiskTo(buffer);
            from.moveDiskTo(to);
            buffer.moveDiskTo(to);
        } else {
            moveDisks(n - 1, from, buffer, to);
            from.moveDiskTo(to);
            moveDisks(n - 1, buffer, to, from);
        }
    }

}
