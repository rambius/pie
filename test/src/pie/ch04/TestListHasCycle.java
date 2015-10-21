package pie.ch04;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class TestListHasCycle {

    private LinkedList<Integer> empty;
    private LinkedList<Integer> list_no_cycle;
    private LinkedList<Integer> list_one_el_no_cycle;
    private LinkedList<Integer> list_one_el_with_cycle;
    private LinkedList<Integer> list_with_cycle;

    @Before
    public void setUp() {
	empty = new LinkedList<Integer>();
	
	list_no_cycle = new LinkedList<Integer>();
	for (int i = 0; i < 5; i++) {
	    list_no_cycle.insertToFront(i);
	}
	
	list_one_el_no_cycle = new LinkedList<Integer>();
	list_one_el_no_cycle.insertToFront(5);

	list_one_el_with_cycle = new LinkedList<Integer>();
	list_one_el_with_cycle.insertToFront(6);
	ListElement<Integer> list_one_el_with_cycle_head = list_one_el_with_cycle.getHead();
	list_one_el_with_cycle_head.setNext(list_one_el_with_cycle_head);
	
	list_with_cycle = new LinkedList<Integer>();
	for (int i = 0; i < 10; i++) {
	    list_with_cycle.insertToFront(i);
	}
	ListElement<Integer> tail = list_with_cycle.find(0);
	ListElement<Integer> el = list_with_cycle.find(6);
	tail.setNext(el);
    }

    @Test
    public void test_has_cycle_iter_empty() {
	assertFalse(LinkedListUtils.hasCycleIter(empty));
    }
    
    @Test
    public void test_has_cycle_iter_list_one_el_no() {
	assertFalse(LinkedListUtils.hasCycleIter(list_one_el_no_cycle));
    }
   
    @Test
    public void test_has_cycle_iter_list_one_el_yes() {
	assertTrue(LinkedListUtils.hasCycleIter(list_one_el_with_cycle));
    }

    @Test
    public void test_has_cycle_iter_no() {
	assertFalse(LinkedListUtils.hasCycleIter(list_no_cycle));
    }
    
    @Test
    public void test_has_cycle_iter_yes() {
	assertTrue(LinkedListUtils.hasCycleIter(list_with_cycle));
    }

    @Test
    public void test_has_cycle_empty() {
	assertFalse(LinkedListUtils.hasCycle(empty));
    }
    
    @Test
    public void test_has_cycle_list_one_el_no() {
	assertFalse(LinkedListUtils.hasCycle(list_one_el_no_cycle));
    }
   
    @Test
    public void test_has_cycle_list_one_el_yes() {
	assertTrue(LinkedListUtils.hasCycle(list_one_el_with_cycle));
    }

    @Test
    public void test_has_cycle_no() {
	assertFalse(LinkedListUtils.hasCycle(list_no_cycle));
    }
    
    @Test
    public void test_has_cycle_yes() {
	assertTrue(LinkedListUtils.hasCycle(list_with_cycle));
    }
}
