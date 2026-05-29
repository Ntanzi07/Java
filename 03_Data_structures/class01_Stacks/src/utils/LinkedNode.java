package utils;

import interfaces.Node;

public class LinkedNode<E> implements Node<E> {
    private E value;
    private Node<E> next;

    public LinkedNode(E value) {
        this.value = value;
    }

    @Override
    public E getValue() {
        return value;
    }

    @Override
    public void setValue(E value) {
        this.value = value;
    }

    @Override
    public Node getNext() {
        return next;
    }

    @Override
    public void setNext(Node next) {
        this.next = next;
    }
}
