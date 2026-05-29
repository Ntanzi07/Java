package utils;

import interfaces.Node;
import interfaces.Stack;

import java.util.EmptyStackException;

public class LinkedStack<E> implements Stack<E> {
    private Node<E> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    @Override
    public void push(E value) {
        Node<E> newNode = new LinkedNode<>(value);

        newNode.setNext(top);
        top = newNode;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        Node<E> temp = top;
        top = top.getNext();
        size--;
        return temp.getValue();
    }

    @Override
    public E peek() {
        if (isEmpty()) throw new EmptyStackException();
        return top.getValue();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
