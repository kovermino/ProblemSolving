package com.joel.problemsolving.round2.problem4;

import com.joel.problemsolving.common.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem4Test {

    Problem4 sut = new Problem4();

    @Test
    void getKthNode_k번째_노드를_찾아야한다() {
        Node root = new Node(null, 0);
        Node node1 = new Node(null, 1);
        Node node2 = new Node(null, 2);
        Node node3 = new Node(null, 3);
        Node node4 = new Node(null, 4);
        root.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);


        assertEquals(node3, sut.getKthNode(root, 2));
    }

    @Test
    void getKthNode_리스트가_null이면_null을_리턴한다() {
        assertEquals(null, sut.getKthNode(null, 2));
    }

    @Test
    void getKthNode_리스트의_길이가_k보다_작으면_null을_리턴한다() {
        Node root = new Node(null, 0);
        Node node1 = new Node(null, 1);
        Node node2 = new Node(null, 2);
        Node node3 = new Node(null, 3);
        Node node4 = new Node(null, 4);
        root.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);


        assertEquals(null, sut.getKthNode(root, 6));
    }

    @Test
    void getKthNode_k가_0이면_null을_리턴한다() {
        Node root = new Node(null, 0);
        Node node1 = new Node(null, 1);
        Node node2 = new Node(null, 2);
        Node node3 = new Node(null, 3);
        Node node4 = new Node(null, 4);
        root.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);


        assertEquals(null, sut.getKthNode(root, 0));
    }
}