package com.joel.problemsolving.round1.problem1;

import com.joel.problemsolving.common.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * 순환 연결 리스트(circular linked list)가 주어졌을때,순환되는 부분의 첫 번째 노드를 리턴하는 알고리즘을 작성하시오.
 * (정의) 순환 연결 리스트는 노드의 다음 포인터가 앞선 노드들 가운데 어느 하나를 가리키도록 설정되어 있는 연결 리스트이다. (망가진 연결리스트라고 볼 수 있음)
 *
 */
public class Problem1 {

    public Node findFirstInCircularLinkedList(Node root) {
        Set<Node> pastNodes = new HashSet<>();
        Node current = root;
        if(current == null) return null;
        while(current != null) {
            if(pastNodes.contains(current)) {
                return current;
            }
            pastNodes.add(current);
            current = current.getNext();
        }
        return null;
    }
}
