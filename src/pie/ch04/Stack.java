package pie.ch04;

public interface Stack<T> {

    public void push(T value);
    public T pop();
    public T peek();

    public int size();
    public boolean isEmpty();
}
