package pie.ch03;

public class FindMaxElGenerics {

    public static <T extends Comparable<T>> T max(T[] array) {
	T max = array[0];
	for (int i = 1; i < array.length; i++) {
	    if (array[i].compareTo(max) > 0) {
		max = array[i];
	    }
	}
	return max;
    }

    public static <T> void print(T[] array) {
	for (int i = 0; i < array.length; i++) {
	    System.out.print(array[i] + " ");
	}
	System.out.println();
    }

    public static void main(String[] args) {
	//RandomMinMax rmm = new RandomMinMax(25, 100);
	Double a[] = {1.0, 2.013, 5.0, 4.0};
	//rmm.randarr(a);
	print(a);
	Double max = max(a);
	System.out.println(max);
    }
}
