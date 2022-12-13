package com.joel.problemsolving.round2.problem4;

import com.joel.problemsolving.common.Node;

public class Problem4Book {
    public Node getKthNode(Node root, int k) {
        Node first = root;
        for(int i=0;i<k;i++) {
            if(first == null) return null;
            first = first.getNext();
        }
        Node second = root;
        while(first != null) {
            first = first.getNext();
            second = second.getNext();
        }
        return second;
    }
}
