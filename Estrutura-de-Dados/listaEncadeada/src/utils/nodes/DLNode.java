package utils.nodes;

import interfaces.nodes.DoubleNode;

public class DLNode<T> implements DoubleNode<T> {
    T value;
    DoubleNode<T> next;
    DoubleNode<T> prev;

    public DLNode(T value) {
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
    public DoubleNode<T> getNext() {
        return next;
    }

    @Override
    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    @Override
    public DoubleNode<T> getPrev() {
        return prev;
    }

    @Override
    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }
}
