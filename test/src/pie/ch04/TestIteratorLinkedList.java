package pie.ch04;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class TestIteratorLinkedList {

    private LinkedList<Integer> empty;
    private LinkedList<Double> one_el_l;
    private LinkedList<Double> list;

    @Before
    public void setUp() {
	empty = new LinkedList<Integer>();
	one_el_l = new LinkedList<Double>();
	one_el_l.insertToFront(12.4);
	list = new LinkedList<Double>();
	for (double i = 0; i < 10; i++) {
	    list.insertToFront(i);
	}
    }

    @Test
    public void test_has_next_empty() {
	Iterator<ListElement<Integer>> i = empty.iterator();
	assertFalse(i.hasNext());
    }

    @Test
    public void test_iterate_empty() {
	for (Iterator<ListElement<Integer>> i = empty.iterator();
	     i.hasNext(); ) {
	    fail();
	}
    }

    @Test
    public void test_iterate_one_el_list() {
	Iterator<ListElement<Double>> i = one_el_l.iterator();
	assertTrue(i.hasNext());
	ListElement<Double> e = i.next();
	assertEquals(new Double(12.4), e.getValue());
	assertFalse(i.hasNext());
    }

    @Test
    public void test_iterate() {
	double d = 10.0;
	for (ListElement<Double> el : list) {
	    assertEquals(new Double(--d), el.getValue());
	    
	}
    }
}
