package utils.lists;

import interfaces.lists.List;
import interfaces.nodes.Node;
import utils.nodes.LNode;
import utils.verifications.Verifications;

public class CircularList<T> implements List<T> {

    Node<T> head;
    Node<T> tail;
    int size;

    @Override
    public T getFirst() {
        return head.getValue();
    }

    @Override
    public T getLast() {
        return tail.getValue();
    }

    @Override
    public void add(T value) {

        Node<T> newNode = new LNode<>(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setNext(head);
        }
        tail = newNode;

        size++;
    }

    private Node<T> getNode(int index) {
        Verifications.IndexOutOfBoundsVerification(index, size);
        Node<T> currentNode = head;
        for (int i = 0; (i < index) && (currentNode != null); i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    @Override
    public T get(int index) {
        return getNode(index).getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(int index) {
        Node<T> currentNode = getNode(index - 1);
        Node<T> nodeToRemove = currentNode.getNext();

        if (size == 1) {
            head = null;
        } else if (nodeToRemove == head) {
            head = nodeToRemove.getNext();
        }

        currentNode.setNext(nodeToRemove.getNext());
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
    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        Node<T> currentNode = head;
        int i = 0;

        while (currentNode != null) {
            array[i++] = currentNode.getValue();
            currentNode = currentNode.getNext();
        }
        return array;
    }
}
