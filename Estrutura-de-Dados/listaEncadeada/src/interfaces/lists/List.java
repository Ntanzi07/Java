package interfaces.lists;

public interface List<T> {
    T getFirst();
    T getLast();
    void add(T value);
    T get(int index);
    int size();
    void remove(int index);
    void clear();
    boolean isEmpty();
    T[] toArray();
    String toString();
}

