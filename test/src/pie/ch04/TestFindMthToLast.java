package pie.ch04;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TestFindMthToLast {

    private LinkedList<Integer> list;

    @Before
    public void setUp() {
	list = new LinkedList<Integer>();
	ListElement<Integer> e = null;
	for (int i = 0; i < 10; i++) {
	    e = list.insertAfter(e, i);
	}
    }

    @Test
    public void test_find_mth_to_last_with_size() {
	int v = FindMthToLast.findMthToLastWithSize(list, 3);
	assertEquals(6, v);
    }

    @Test
    public void test_find_mth_to_last_with_size_last() {
	int v = FindMthToLast.findMthToLastWithSize(list, 0);
	assertEquals(9, v);
    }

    @Test
    public void test_find_mth_to_last_with_size_first() {
	int v = FindMthToLast.findMthToLastWithSize(list, 9);
	assertEquals(0, v);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void test_find_mth_to_last_with_size_out_of_bounds() {
	int v = FindMthToLast.findMthToLastWithSize(list, 10);
	assertEquals(6, v);
    }

        @Test
    public void test_find_mth_to_last() {
	int v = FindMthToLast.findMthToLast(list, 3);
	assertEquals(6, v);
    }

    @Test
    public void test_find_mth_to_last_last() {
	int v = FindMthToLast.findMthToLast(list, 0);
	assertEquals(9, v);
    }

    @Test
    public void test_find_mth_to_last_first() {
	int v = FindMthToLast.findMthToLast(list, 9);
	assertEquals(0, v);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void test_find_mth_to_last_out_of_bounds() {
	int v = FindMthToLast.findMthToLast(list, 10);
	assertEquals(6, v);
    }

}
