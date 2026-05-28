package utils.lists;

import interfaces.lists.List;
import interfaces.nodes.Node;
import utils.nodes.LNode;
import utils.verifications.Verifications;

public class LinkedList<E> implements List<E> {

    Node<E> head;
    Node<E> tail;
    int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public E getFirst() {
        return head.getValue();
    }

    @Override
    public E getLast() {
        return tail.getValue();
    }

    @Override
    public void add(E value) {
        Node<E> newNode = new LNode<>(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    @Override
    public E get(int index) {
        Verifications.IndexOutOfBoundsVerification(index, size);

        Node<E> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        return currentNode.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(int index) {
        Verifications.IndexOutOfBoundsVerification(index, size);

        Node<E> currentNode = head;
        Node<E> preNode = null;
        for (int i = 0; i < index; i++) {
            preNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (preNode == null) {
            head = currentNode.getNext();
        } else {
            preNode.setNext(currentNode.getNext());
        }

        if (currentNode.getNext() == null)
            tail = preNode;

        size--;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        Node<E> currentNode = head;

        int i = 0;
        while (currentNode != null){
            array[i++] = currentNode.getValue();
            currentNode = currentNode.getNext();
        }

        return array;
    }
}
