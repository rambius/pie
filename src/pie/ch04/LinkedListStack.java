package pie.ch04;

public class LinkedListStack<T> implements Stack<T> {
    
    private LinkedList<T> list;

    public LinkedListStack() {
	list = new LinkedList<T>();
    }

    public int size() {
	return list.size();
    }

    public boolean isEmpty() {
	return list.isEmpty();
    }

    public T peek() {
	if (isEmpty()) {
	    return null;
	}
	return list.get(0);
    }

    public T pop() {	
	if (isEmpty()) {
	    return null;
	}
	ListElement<T> head = list.deleteHead();
	return head.getValue();
    }

    public void push(T value) {
	list.insertToFront(value);
    }
}
