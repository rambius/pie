package pie.ch04;

public class ListElement<T> {

    private T value;
    private ListElement<T> next;

    public ListElement(T value) {
	this.value = value;
    }

    public void setNext(ListElement<T> next) {
	this.next = next;
    }

    public ListElement<T> getNext() {
	return next;
    }

    public void setValue(T value) {
	this.value = value;
    }

    public T getValue() {
	return value;
    }

    public String toString() {
	return String.valueOf(value);
    }
}
