package pie.ch04;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class TestLinkedListStack {

    private Stack<Double> empty;
    private Stack<Double> stack;

    @Before
    public void setUp() {
	empty = new LinkedListStack<Double>();       
	stack = new LinkedListStack<Double>();
	stack.push(3.14);
	stack.push(2.12);
	stack.push(5.3);
	stack.push(4.0);
    }

    @Test
    public void test_is_empty() {
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
    public void test_size() {
	assertEquals(4, stack.size());
    }

    @Test
    public void test_peek() {
	double d = stack.peek();
	assertEquals(4.0, d, 0);
    }

    
    @Test
    public void test_peek_empty() {
	assertNull(empty.peek());
    }

    @Test
    public void test_push() {
	double d = 2.83;
	stack.push(d);
	assertEquals(5, stack.size());
	assertEquals(d, stack.peek(), 0);
    }

    @Test
    public void test_pop_empty() {
	assertNull(empty.pop());
    }

    @Test
    public void test_pop() {
	double d = 6.87;
	stack.push(d);
	double d1 = stack.pop();
	assertEquals(4, stack.size());
	assertEquals(d, d1, 0);
	assertEquals(4.0, stack.peek(), 0);
    }    
}
