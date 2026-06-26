package utils;

import interfaces.Node;
import interfaces.Tree;

import java.util.ArrayList;
import java.util.List;

public class BinTree<T extends Comparable<T>> implements Tree<T> {

    Node<T> root;
    int size;

    public BinTree() {
        root = null;
    }

    @Override
    public void add(T value) {
        Node<T> newNode = new BinNode<>(value);
        root = insert(root, newNode);
        size++;
    }

    private Node<T> insert(Node<T> current, Node<T> newNode) {

        if (current == null) {
            return newNode;
        } else if (newNode.value().compareTo(current.value()) < 0) {
            current.setLeft(insert(current.left(), newNode));
        } else {
            current.setRight(insert(current.right(), newNode));
        }

        return current;
    }

    @Override
    public void remove(T value) {
        root = remove(root, value);
    }

    private Node<T> remove(Node<T> current, T value) {
        if (current == null) return null;

        int cmp = value.compareTo(current.value());

        if (cmp < 0) {
            current.setLeft(remove(current.left(), value));
        } else if (cmp > 0) {
            current.setRight(remove(current.right(), value));
        } else {
            size--;
            if (current.left() == null) {
                return current.right();
            } else if (current.right() == null) {
                return current.left();
            }

            Node<T> successor = findMin(current.right());
            current.setValue(successor.value());
            current.setRight(remove(current.right(), value));
        }

        return current;
    }

    private Node<T> findMin(Node<T> node) {
        while (node.left() != null) {
            node = node.left();
        }
        return node;
    }

    @Override
    public boolean contains(T value) {
        return contains(root, value) != null;
    }

    private Node<T> contains(Node<T> current, T value) {
        if (current == null) return null;

        int cmp = value.compareTo(current.value());
        if (cmp == 0) {
            return current;
        } else if (cmp < 0) {
            return contains(current.left(), value);
        } else {
            return contains(current.right(), value);
        }

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public String inOrder() {
        List<String> values = new ArrayList<>();
        inOrder(root, values);
        return "InOrder Tree[" + String.join(", ", values) + "]";
    }

    private void inOrder(Node<T> current, List<String> values) {
        if (current != null) {
            inOrder(current.left(), values);
            values.add(String.valueOf(current.value()));
            inOrder(current.right(), values);
        }
    }

    @Override
    public String preOrder() {
        List<String> values = new ArrayList<>();
        preOrder(root, values);
        return "preOrder Tree[" + String.join(", ", values) + "]";
    }

    private void preOrder(Node<T> current, List<String> values) {
        if (current != null) {
            values.add(String.valueOf(current.value()));
            preOrder(current.left(), values);
            preOrder(current.right(), values);
        }
    }

    @Override
    public String postOrder() {
        List<String> values = new ArrayList<>();
        postOrder(root, values);
        return "postOrder Tree[" + String.join(", ", values) + "]";
    }

    private void postOrder(Node<T> current, List<String> values) {
        if (current != null) {
            postOrder(current.left(), values);
            postOrder(current.right(), values);
            values.add(String.valueOf(current.value()));
        }
    }
}
