package pie.ch03;

public class FindMaxEl {

    public static double max(double[] array) {
	double max = array[0];
	for (int i = 1; i < array.length; i++) {
	    if (array[i] > max) {
		max = array[i];
	    }
	}
	return max;
    }

    public static void print(double[] array) {
	for (int i = 0; i < array.length; i++) {
	    System.out.print(array[i] + " ");
	}
	System.out.println();
    }

    public static void main(String[] args) {
	RandomMinMax rmm = new RandomMinMax(25, 100);
	double a[] = new double[5];
	rmm.randarr(a);
	print(a);
	double max = max(a);
	System.out.println(max);
    }
}
