package com.joel.problemsolving.round3.problem6;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 두 개의 이진트리 T1과 T2가 있다고 하자. T1에는 수백만 개의 노드가 있고, T2에는 수백 개 정도의 노드가 있다.
 * T2가 T1의 하위 트리인지 판별하는 알고리즘을 구현하라.
 * (T1안에 노드 n이 있고, 그 노드 n으로부터 시작하는 트리가 T2와 동일하면, 즉 구조와 데이터가 전부 일치하면 T2는 T1의 하위트리이다.
 *  다시말해 T1에서 n부터 시작하여 그 아래쪽을 끊어내면 그 결과가 T2와 동일해야 한다.)
 */
public class Problem6 {

    public boolean isSubTree(TreeNode big, TreeNode small) {
        if(big == null) return false;
        if(small == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(big);
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if(isEqualTree(current, small))  return true;
            if(current.getLeft() != null) queue.offer(current.getLeft());
            if(current.getRight() != null) queue.offer(current.getRight());
        }
        return false;
    }

    public boolean isEqualTree(TreeNode first, TreeNode second) {
        if(first == null && second == null) {
            return true;
        } else if(first == null && second != null) {
            return false;
        } else if(first != null && second == null) {
            return false;
        } else if(first.getData() != second.getData()) {
            return false;
        } else {
            boolean isLeftTreeSame = isEqualTree(first.getLeft(), second.getLeft());
            boolean isRightTreeSame = isEqualTree(first.getRight(), second.getRight());
            return isLeftTreeSame && isRightTreeSame;
        }
    }
}
