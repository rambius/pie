package pie.ch05;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TestBST {

    private BST<Integer> tree;

    @Before
    public void setUp() {
	tree = new BST<Integer>();
    }

    @Test
    public void test_size_tree() {
	assertEquals(0, tree.sizeRec());
    }

    @Test
    public void test_size_no_children() {
	tree.addRec(5);
	assertEquals(1, tree.sizeRec());
    }

    @Test
    public void test_size() {
	tree.addRec(4);
	tree.addRec(3);
	tree.addRec(5);
	assertEquals(3, tree.sizeRec());
    }
}
