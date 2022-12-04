package com.joel.problemsolving.round1.problem1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {

    @Test
    void 순환고리의_첫번째_노드를_리턴한다() {
        Node root = new Node(null, 0);
        Node node1 = new Node(null, 1);
        Node node2 = new Node(null, 2);
        Node node3 = new Node(null, 3);
        Node node4 = new Node(null, 4);
        root.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node2);


        Problem1 sut = new Problem1();
        Node result = sut.findFirstInCircularLinkedList(root);


        assertEquals(node2, result);
    }

    @Test
    void 순환고리의_첫번째_노드가_root인_경우에는_root를_리턴한다() {
        Node root = new Node(null, 0);
        Node node1 = new Node(null, 1);
        Node node2 = new Node(null, 2);
        Node node3 = new Node(null, 3);
        Node node4 = new Node(null, 4);
        root.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(root);


        Problem1 sut = new Problem1();
        Node result = sut.findFirstInCircularLinkedList(root);


        assertEquals(root, result);
    }

    @Test
    void 순환고리가_없는_경우에는_null을_리턴한다() {
        Node root = new Node(null, 0);
        Node node1 = new Node(null, 1);
        Node node2 = new Node(null, 2);
        Node node3 = new Node(null, 3);
        Node node4 = new Node(null, 4);
        root.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);


        Problem1 sut = new Problem1();
        Node result = sut.findFirstInCircularLinkedList(root);


        assertNull(result);
    }

    @Test
    void null을_입력받으면_null을_리턴한다() {
        Problem1 sut = new Problem1();
        Node result = sut.findFirstInCircularLinkedList(null);


        assertNull(result);
    }
}