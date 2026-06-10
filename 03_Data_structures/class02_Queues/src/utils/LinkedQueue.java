package utils;

import interfaces.Node;
import interfaces.Queue;

public class LinkedQueue<T> implements Queue<T> {
    Node<T> head;
    Node<T> tail;
    int size;

    public LinkedQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void push(T element) {
        Node<T> newNode = new LinkedNode<>(element);
        if(isEmpty()){
            tail = newNode;
            head = newNode;
        }else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    @Override
    public T pop() {
        if(isEmpty())
            return null;

        T resp = head.getValue();
        head = head.getNext();
        size--;
        return resp;
    }

    @Override
    public T peek() {
        return head.getValue();
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
