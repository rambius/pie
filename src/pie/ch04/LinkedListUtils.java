package pie.ch04;

import java.util.Iterator;

public class LinkedListUtils {

    public static <T> boolean hasCycleIter(LinkedList<T> list) {
	Iterator<ListElement<T>> slow = list.iterator();
	Iterator<ListElement<T>> fast = list.iterator();
	if (fast.hasNext()) {
	    fast.next();
	} else {
	    return false;
	}
	while (slow.hasNext() && fast.hasNext()) {
	    ListElement<T> ef = fast.next();
	    ListElement<T> es = slow.next();
	    if (ef == es) {
		return true;
	    }
	    if (!fast.hasNext()) {
		return false;
	    }
	    ef = fast.next();
	    if (ef == es) {
		return true;
	    }
	}
	return false;
    }

    public static <T> boolean hasCycle(LinkedList<T> list) {
	if (list.isEmpty()) {
	    return false;
	}
	ListElement<T> slow = list.getHead();	
	ListElement<T> fast = slow.getNext();
	while (true) {
	    if (fast == null || fast.getNext() == null) {
		return false;
	    }
	    if (slow == fast || slow == fast.getNext()) {
		return true;
	    }
	    slow = slow.getNext();
	    fast = fast.getNext().getNext();
	}
    }
}
