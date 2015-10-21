package pie.ch04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class TestLinkedList {

    private LinkedList<Integer> l;

    @Before
    public void setUp() {
	l = new LinkedList<Integer>();
	assertEquals(0, l.size());
	l.insertToFront(1);
	assertEquals(1, l.size());
	l.insertToFront(2);
	assertEquals(2, l.size());
	l.insertToFront(3);
	assertEquals(3, l.size());
    }

    @Test
    public void test_size_empty() {
	LinkedList<Integer> le = new LinkedList<Integer>();
	assertEquals(0, le.size());
    }

    @Test
    public void test_is_empty_yes() {
	LinkedList<Integer> le = new LinkedList<Integer>();
	assertTrue(le.isEmpty());
    }

    @Test
    public void test_is_empty_no() {
	assertFalse(l.isEmpty());
    }
    
    @Test
    public void test_insert_to_front() {
	l.insertToFront(4);
	assertEquals(4, l.size());
	assertEquals(new Integer(4), l.get(0));	
    }

    @Test
    public void test_insert_after_null() {
	int value = 5;
	l.insertAfter(null, value);
	assertEquals(4, l.size());
	assertEquals(new Integer(value), l.get(0));
    }

    @Test
    public void test_insert_after_non_existing() {
	ListElement<Integer> e = new ListElement<Integer>(5);
	assertNull(null, l.insertAfter(e, 6));
    }

    @Test
    public void test_get() {
	assertEquals(new Integer(3), l.get(0));
	assertEquals(new Integer(2), l.get(1));
	assertEquals(new Integer(1), l.get(2));
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void test_get_out_of_bounds_size() {
	l.get(3);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void test_get_out_of_beyond_size() {
	l.get(5);
    }

    @Test(expected=IllegalArgumentException.class)
    public void test_get_negative_index() {
	l.get(-5);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void test_get_empty_list() {
	LinkedList<Integer> le = new LinkedList<Integer>();
	le.get(5);
    }

    @Test
    public void test_find() {
	ListElement<Integer> e = l.find(1);
	assertEquals(new Integer(1), e.getValue());
    }

    @Test
    public void test_find_non_existing() {
	ListElement<Integer> e = l.find(4);
	assertNull(e);
    }

    @Test
    public void test_delete_head() {
	ListElement<Integer> h = l.find(3);
	ListElement<Integer> d = l.delete(h);
	assertNull(l.find(3));
	assertEquals(new Integer(3), d.getValue());
	assertEquals(2, l.size());
	assertEquals(new Integer(2), l.get(0));
	assertEquals(new Integer(1), l.get(1));
    }

    @Test
    public void test_delete_middle() {
	ListElement<Integer> m = l.find(2);
	ListElement<Integer> d = l.delete(m);
	assertNull(l.find(2));
	assertEquals(new Integer(2), d.getValue());
	assertEquals(2, l.size());
	assertEquals(new Integer(3), l.get(0));
	assertEquals(new Integer(1), l.get(1));
    }

    @Test
    public void test_delete_tail() {
	ListElement<Integer> t = l.find(1);
	ListElement<Integer> d = l.delete(t);
	assertNull(l.find(1));
	assertEquals(new Integer(1), d.getValue());
	assertEquals(2, l.size());
	assertEquals(new Integer(3), l.get(0));
	assertEquals(new Integer(2), l.get(1));
	
    }

    @Test
    public void test_count() {
	assertEquals(3, l.count());	
    }
}
