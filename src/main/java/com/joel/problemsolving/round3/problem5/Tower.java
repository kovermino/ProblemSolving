package com.joel.problemsolving.round3.problem5;

import java.util.Stack;

public class Tower {

    private Stack<Integer> disks;

    public Tower() {
        this.disks = new Stack<>();
    }

    public Tower(int diskCount) throws Exception {
        build(diskCount);
    }

    public int pop() {
        return disks.pop();
    }

    public boolean isEmpty() {
        return disks.isEmpty();
    }

    public int getDiskCount() {
        return disks.size();
    }

    public void build(int diskCount) throws Exception {
        disks = new Stack<>();
        for(int i=diskCount;i>0;i--) {
            push(i);
        }
    }

    public void moveDiskTo(Tower other) throws Exception {
        int top = this.disks.pop();
        other.push(top);
    }

    private void push(int disk) throws Exception {
        if(!disks.isEmpty() && disks.peek() < disk) {
            throw new Exception("가장 위에 있는 원판보다 큰 원판은 넣을 수 없습니다.");
        }
        disks.push(disk);
    }
}
