package interfaces;

public interface Tree<T extends Comparable<T>> {
    void add(T value);
    void remove(T value);
    boolean contains(T value);
    int size();
    boolean isEmpty();
    void clear();
    String inOrder();
    String preOrder();
    String postOrder();
}
