package pie.ch04;

public class FindMthToLast {

    public static <T> T findMthToLastWithSize(LinkedList<T> list, int m) {
	int size = list.size();
	if (m < 0 || m >= size) {
	    throw new IndexOutOfBoundsException("index cannot be negative or beyond the size of the list");
	}
	T r = list.get(size - m - 1);
	return r;
    }

    public static <T> T findMthToLast(LinkedList<T> list, int m) {
	if (m < 0) {
	    throw new IndexOutOfBoundsException("index cannot be negative");
	}
	ListElement<T> c = list.getHead();
	for(int i = 0; i < m; i++) {
	    c = c.getNext();
	    if (c == null) {
		throw new IndexOutOfBoundsException("index cannot be beyond the size of the list");
	    }
	}
	ListElement<T> mth = list.getHead();
	while (c.getNext() != null) {
	    c = c.getNext();
	    mth = mth.getNext();
	}
	return mth.getValue();
    }
}
