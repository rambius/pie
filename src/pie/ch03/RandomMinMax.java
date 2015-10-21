package pie.ch03;

import java.util.Random;

public class RandomMinMax {

    private int min;
    private int max;
    private Random random;

    public RandomMinMax(int min, int max) {
	this.min = min;
	this.max = max;
	random = new Random();
    }

    public double randdouble() {
	double d = random.nextDouble();
	double r = d * (max - min) + min;
	return r;
    }

    public void randarr(double array[]) {
	for (int i = 0; i < array.length; i++) {
	    array[i] = randdouble();
	}
    }

}
