package pie.ch04;

public class ArrayStack<T> implements Stack<T> {

    private T[] array;
    private int count;
    private int growthCapacity;

    private static final int DEFAULT_CAPACITY = 10;
    private static final int GROWTH_CAPACITY = 10;

    public ArrayStack() {
	this(DEFAULT_CAPACITY, GROWTH_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity, int growthCapacity) {
	array = (T[])new Object[capacity];
	count = 0;
	this.growthCapacity = growthCapacity;
    }

    public T peek() {
	if (isEmpty()) {
	    return null;
	}
	return array[count - 1];
    }

    public T pop() {
	if (isEmpty()) {
	    return null;
	}
	T value = array[count - 1];	
	array[count - 1] = null;
	count--;
	return value;
    }

    public void push(T value) {
	if (count == array.length) {
	    resizeArray();
	}
	array[count] = value;
	count++;
    }

    public boolean isEmpty() {
	return size() == 0;
    }

    public int size() {
	return count;
    }

    private void resizeArray() {
	T[] newArray = createNewArray();
	copyArrayTo(newArray);	
	array = newArray;
    }
    
    @SuppressWarnings("unchecked")
    private T[] createNewArray() {
	int newLength = array.length + growthCapacity;
	T[] newArray = (T[])new Object[newLength];
	return newArray;
    }

    private void copyArrayTo(T[] newArray) {
	System.arraycopy(array, 0, newArray, 0, array.length);
    }
}
