package interfaces;

public interface Queue<T> {
    void push(T element);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}
