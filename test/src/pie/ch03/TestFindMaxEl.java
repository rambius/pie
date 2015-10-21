package pie.ch03;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestFindMaxEl {

    private RandomMinMax rmm;

    @Before
    public void setUp() {
	rmm = new RandomMinMax(3, 10);
    }

    @Test
    public void test_fixed_array() {
	double d[] = {1.13, 2.56, 7.43, 3.5, 5.01, 8.54, 6.0, 0.5, 7.65};
	double max = FindMaxEl.max(d);
	assertEquals(8.54, max, 0);
    }

    @Test
    public void test_random_array() {
	double d[] = new double[10];
	rmm.randarr(d);
	double max = FindMaxEl.max(d);
	assertMaxEl(max, d);
    }

    private void assertMaxEl(double max, double d[]) {
	for (int i = 0; i < d.length; i++) {
	    assertTrue(max >= d[i]);
	}
    }
}
