package utils.nodes;

import interfaces.nodes.Node;

public class LNode<T> implements Node<T> {
    T value;
    Node<T> next;

    public LNode(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public Node<T> getNext() {
        return next;
    }

    @Override
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
