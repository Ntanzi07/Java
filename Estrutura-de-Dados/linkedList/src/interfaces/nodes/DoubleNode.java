package interfaces.nodes;

public interface DoubleNode<T> {
    T getValue();
    void setValue(T value);
    DoubleNode<T> getNext();
    void setNext(DoubleNode<T> next);
    DoubleNode<T> getPrev();
    void setPrev(DoubleNode<T> prev);
}
