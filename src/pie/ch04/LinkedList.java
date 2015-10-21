package pie.ch04;

import java.util.Iterator;
import java.util.NoSuchElementException;

class ListElement<T> {

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

public class LinkedList<T> implements Iterable<ListElement<T>> {

    private ListElement<T> head;
    private int size;

    public LinkedList() {
	head = null;
	size = 0;
    }
    
    public ListElement<T> getHead() {
	return head;
    }

    public ListElement<T> insertToFront(T value) {
	ListElement<T> newHead = new ListElement<T>(value);
	newHead.setNext(head);
	head = newHead;
	size++;
	return head;
    }

    public ListElement<T> insertAfter(ListElement<T> e, T value) {
	if (e == null) {
	    return insertToFront(value);
	}
	ListElement<T> c = head;
	while (c != null) {
	    if (e == c) {
		ListElement<T> newEl = new ListElement<T>(value);
		newEl.setNext(c.getNext());
		e.setNext(newEl);
		size++;
		return newEl;
	    }
	    c = c.getNext();
	}
	return null;
    }

    public ListElement<T> delete(ListElement<T> e) {
	if (isEmpty()) {
	    return null;
	}
	ListElement<T> c = head;
	if (e == head) {
	    return deleteHead();
	}
	while (c != null) {
	    if (e == c.getNext()) {
		c.setNext(e.getNext());
		size--;
		return e;
	    }
	    c = c.getNext();
	}
	return null;
    }

    public ListElement<T> deleteHead() {
	if (isEmpty()) {
	    return null;
	}
	ListElement<T> c = head;	
	head = head.getNext();
	size--;
	return c;
    }

    public T get(int index) {
	if (index < 0) {
	    throw new IllegalArgumentException("index " + index + " can not be negative");
	}
	int i;
	if (isEmpty()) {
	    throw new IndexOutOfBoundsException(index + " is not a valid index for an empty list");
	}
	ListElement<T> c = head;
	for (i = 0; i < index; i++) {	    
	    c = c.getNext();
	    if (c == null) {
		throw new IndexOutOfBoundsException(index + " is not a valid index");
	    }
	}
	return c.getValue();
    }

    public int size() {
	return size;
    }

    public int count() {
	int i = 0;
	ListElement<T> c = head;
	while (c != null) {
	    i++;
	    c = c.getNext();
	}
	return i;
    }

    public boolean isEmpty() {
	return (head == null);
    }

    public ListElement<T> find(T value) {
	ListElement<T> c = head;
	while(c != null && !c.getValue().equals(value)) {
	    c = c.getNext();
	}
	return c;
    }

    public Iterator<ListElement<T>> iterator() {
	return new LinkedListIterator<T>(this);
    }

    public String toString() {
	StringBuffer sb = new StringBuffer(); 
	ListElement<T> c = head;
	while (c != null) {
	    sb.append(String.valueOf(c));
	    sb.append(" ");
	    c = c.getNext();
	}
	return sb.toString();
    }

}

class LinkedListIterator<T> implements Iterator<ListElement<T>> {

    private ListElement<T> next;

    public LinkedListIterator(LinkedList<T> list) {
	next = list.getHead();
    }

    public void remove() {
	throw new UnsupportedOperationException();
    }

    public ListElement<T> next() {
	if (next == null) {
	    throw new NoSuchElementException();
	}
	ListElement<T> t = next;
	next = next.getNext();
	return t;
    }

    public boolean hasNext() {
	return (next != null);
    }
}
