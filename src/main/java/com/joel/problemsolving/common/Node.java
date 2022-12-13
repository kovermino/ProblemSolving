package com.joel.problemsolving.common;

import java.util.Objects;

public class Node {
    private Node next;
    private int data;

    public Node(Node next, int data) {
        this.next = next;
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public int getData() {
        return data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return data == node.data && Objects.equals(next, node.next);
    }
}
