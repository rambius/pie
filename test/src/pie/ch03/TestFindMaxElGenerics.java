package pie.ch03;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestFindMaxElGenerics {

    @Test
    public void test_Double_array() {
	Double d[] = {1.13, 2.56, 7.43, 3.5, 5.01, 8.54, 6.0, 0.5, 7.65};
	Double max = FindMaxElGenerics.max(d);
	assertEquals(8.54, max, 0);
    }

    @Test
    public void test_Integer_array() {
	Integer i[] = {7, 6, 9, 4, 5, 11, 0, 4};
	Integer max = FindMaxElGenerics.max(i);
	assertEquals(Double.valueOf(11), Double.valueOf(max), 0);
    }

    @Test
    public void test_String_array() {
	String s[] = {"ccc", "aa", "d", "a", "b"};
	String max = FindMaxElGenerics.max(s);
	assertEquals("d", max);
    }
}
