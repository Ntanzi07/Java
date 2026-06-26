package utils;

import interfaces.Node;

public class BinNode<T extends Comparable<T>> implements Node<T> {
    T value;
    Node<T> left;
    Node<T> right;

    public BinNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public BinNode() {
    }

    @Override
    public T value() {
        return value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public Node<T> left() {
        return left;
    }

    @Override
    public void setLeft(Node<T> left) {
        this.left = left;
    }

    @Override
    public Node<T> right() {
        return right;
    }

    @Override
    public void setRight(Node<T> right) {
        this.right = right;
    }
}
