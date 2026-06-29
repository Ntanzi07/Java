package utils;

import interfaces.Node;
import interfaces.Tree;

import java.util.ArrayList;
import java.util.List;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {
    Node<T> root;
    int size;

    private int height(Node<T> node) {
        return node == null ? 0 : node.height();
    }

    private int balanceFactor(Node<T> node) {
        return node == null ? 0 : height(node.left()) - height(node.right());
    }

    private void updateHeight(Node<T> node) {
        if (node == null) return;
        node.setHeight(1 + Math.max(height(node.left()), height(node.right())));
    }

    private Node<T> rotateRight(Node<T> y) {
        Node<T> x = y.left();
        y.setLeft(x.right());
        x.setRight(y);
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node<T> rotateLeft(Node<T> x) {
        Node<T> y = x.right();
        x.setRight(y.left());
        y.setRight(x);
        updateHeight(x);
        updateHeight(y);
        return y;
    }

    private Node<T> balance(Node<T> node) {
        int bf = balanceFactor(node);

        if (bf > 1 && balanceFactor(node.left()) >= 0) {
            return rotateRight(node);
        }
        if (bf > 1 && balanceFactor(node.left()) < 0) {
            node.setLeft(rotateLeft(node.left()));
            return rotateRight(node);
        }
        if (bf < -1 && balanceFactor(node.right()) <= 0) {
            return rotateLeft(node);
        }
        if (bf < -1 && balanceFactor(node.right()) > 0) {
            node.setRight(rotateRight(node.right()));
            return rotateLeft(node);
        }

        return node;
    }

    @Override
    public void add(T value) {
        root = insert(root, new BinNode<T>(value));
        size++;
    }

    private Node<T> insert(Node<T> current, Node<T> newNode) {
        if (current == null) return newNode;

        int cmp = newNode.value().compareTo(current.value());
        if (cmp < 0) {
            current.setLeft(insert(current.left(), newNode));
        } else {
            current.setRight(insert(current.right(), newNode));
        }

        updateHeight(current);
        return balance(current);
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
            if(current.left() == null){
                size--;
                return current.right();
            } else if (current.right() == null) {
                size--;
                return current.left();
            }

            Node<T> successor = findMin(current.right());
            current.setValue(successor.value());
            current.setRight(remove(current.right(), successor.value()));
        }

        updateHeight(current);
        return balance(current);
    }
    private Node<T> findMin(Node<T> node){
        while (node.left() != null){
            node = node.left();
        }
        return node;
    }

    @Override
    public boolean contains(T value) {
        return search(root, value) != null;
    }

    private Node<T> search(Node<T> current, T value) {
        if (current == null) return null;

        int cmp = value.compareTo(current.value());
        if (cmp == 0) {
            return current;
        } else if (cmp < 0) {
            return search(current.left(), value);
        } else {
            return search(current.right(), value);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public String inOrder() {
        List<String> list = new ArrayList<>();
        inOrder(root, list);
        return String.join(", ", list);
    }

    private void inOrder(Node<T> current, List<String> list) {
        if (current == null) return;
        inOrder(current.left(), list);
        list.add(current.value().toString());
        inOrder(current.right(), list);
    }

    @Override
    public String preOrder() {
        List<String> list = new ArrayList<>();
        preOrder(root, list);
        return String.join(", ", list);
    }

    private void preOrder(Node<T> current, List<String> list) {
        if (current == null) return;
        list.add(current.value().toString());
        preOrder(current.left(), list);
        preOrder(current.right(), list);
    }

    @Override
    public String postOrder() {
        List<String> list = new ArrayList<>();
        postOrder(root, list);
        return String.join(", ", list);
    }

    private void postOrder(Node<T> current, List<String> list) {
        if (current == null) return;
        postOrder(current.left(), list);
        postOrder(current.right(), list);
        list.add(current.value().toString());
    }
}
