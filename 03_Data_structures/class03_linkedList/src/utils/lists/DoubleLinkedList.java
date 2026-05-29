package utils.lists;

import interfaces.lists.List;
import interfaces.nodes.DoubleNode;
import utils.nodes.DLNode;
import utils.verifications.Verifications;

public class DoubleLinkedList<E> implements List<E> {

    private DoubleNode<E> head;
    private DoubleNode<E> tail;
    private int size;

    public DoubleLinkedList() {
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
        DoubleNode<E> newNode = new DLNode<>(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
        }
        tail = newNode;
        size++;
    }

    @Override
    public E get(int index) {
        Verifications.IndexOutOfBoundsVerification(index, size);
        DoubleNode<E> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode.getNext();
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

        DoubleNode<E> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode.getNext();
        }

        if (currentNode.getPrev() == null)
            head = currentNode.getNext();
        else
            currentNode.getPrev().setNext(currentNode.getNext());

        if (currentNode.getNext() != null)
            tail = currentNode.getNext();
        else
            currentNode.getNext().setPrev(currentNode.getPrev());

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
        DoubleNode<E> currentNode = head;
        int i = 0;

        while (currentNode != null) {
            array[i++] = currentNode.getValue();
            currentNode = currentNode.getNext();
        }
        return array;
    }
}
