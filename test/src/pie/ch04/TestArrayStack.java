package pie.ch04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class TestArrayStack {

    private Stack<Integer> empty;
    private Stack<Double> stack;

    @Before
    public void setUp() {
	empty = new ArrayStack<Integer>();
	stack = new ArrayStack<Double>();
	stack.push(3.14);
    }

    @Test
    public void test_empty() {
	assertTrue(empty.isEmpty());
    }

    @Test
    public void test_not_empty() {
	assertFalse(stack.isEmpty());
    }

    @Test
    public void test_size_empty() {
	assertEquals(0, empty.size());
    }

    @Test
    public void test_size_not_empty() {
	assertEquals(1, stack.size());
    }

    @Test
    public void test_push() {
	double value = 2.17;
	stack.push(value);
	assertEquals(2, stack.size());
	assertEquals(new Double(value), stack.peek());
    }
    
    @Test
    public void test_peek_empty() {
	assertNull(empty.peek());
    }
    
    
    @Test
    public void test_pop_empty() {
	assertNull(empty.pop());
    }

    @Test
    public void test_pop() {
	double value = 3.27;
	stack.push(value);
	assertEquals(2, stack.size());
	assertEquals(new Double(value), stack.pop());	
	assertEquals(1, stack.size());
    }

    @Test
    public void test_push_over_initial_capacity() {	
	for (int i = 1; i < 10; i++) {
	    stack.push(new Double(i));
	}
	double value = 10.326;
	stack.push(value);
	assertEquals(11, stack.size());
	assertEquals(new Double(value), stack.peek());
	assertEquals(new Double(value), stack.pop());
	value = 9.0;
	assertEquals(new Double(value), stack.peek());
    }
}
