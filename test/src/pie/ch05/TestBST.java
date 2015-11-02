package pie.ch05;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class TestBST {

    private BST<Integer> empty;
    private BST<Integer> small;
    private BST<Integer> big;

    @Before
    public void setUp() {
	empty = new BST<Integer>();

	small = new BST<Integer>();
	small.addRec(8);
	small.addRec(1);
	small.addRec(14);

	big = new BST<Integer>();
	big.addRec(5);
	big.addRec(3);
	big.addRec(10);
	big.addRec(1);
	big.addRec(4);
	big.addRec(7);
	big.addRec(12);
    }

    @Test
    public void test_is_empty_yes() {
	assertTrue(empty.isEmpty());
    }

    @Test
    public void test_is_empty_no() {
	assertFalse(small.isEmpty());
	assertFalse(big.isEmpty());
    }

    @Test
    public void test_size_empty() {
	assertEquals(0, empty.sizeRec());
    }

    @Test
    public void test_size_no_children() {
	empty.addRec(5);
	assertEquals(1, empty.sizeRec());
    }

    @Test
    public void test_size_small() {
	assertEquals(3, small.sizeRec());
    }

    @Test
    public void test_size_big() {
	assertEquals(7, big.sizeRec());
    }

    @Test
    public void test_min_empty() {
	assertNull(empty.min());
    }

    @Test
    public void test_min_small() {
	assertEquals(new Integer(1), small.min());
    }
    
    @Test
    public void test_min_big() {
	assertEquals(new Integer(1), big.min());
    }

    @Test
    public void test_max_empty() {
	assertNull(empty.max());
    }

    @Test
    public void test_max_small() {
	assertEquals(new Integer(14), small.max());
    }
    
    @Test
    public void test_max_big() {
	assertEquals(new Integer(12), big.max());
    }
}
