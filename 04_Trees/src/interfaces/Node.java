package interfaces;

public interface Node<T extends Comparable<T>>{
    T value();
    void setValue(T value);
    Node<T> left();
    void setLeft(Node<T> left);
    Node<T> right();
    void setRight(Node<T> right);
}
