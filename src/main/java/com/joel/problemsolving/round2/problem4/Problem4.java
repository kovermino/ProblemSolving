package com.joel.problemsolving.round2.problem4;

import com.joel.problemsolving.common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 단방향 Linked List에서 뒤에서 k번째 노드를 찾는 알고리즘을 구현하라.
 */
public class Problem4 {

    public Node getKthNode(Node root, int k) {
        if(root == null) return null;
        if(k == 0) return null;
        List<Node> array = new ArrayList<>();
        array.add(root);
        Node current = root;
        while(current.getNext() != null) {
            current = current.getNext();
            array.add(current);
        }
        if(array.size() < k) return null;
        int index = array.size() - k;
        return array.get(index);
    }
}
