package pie.ch09;

public class IntBuffer {

    private int[] buffer;
    private int index;
    
    public IntBuffer() {
	this(8);
    }

    public IntBuffer(int bufferLength) {
	buffer = new int[bufferLength];
	index = 0;
    }

    public synchronized void add(int num) {
	if (index == buffer.length - 1) {
	    try {
		wait();
	    } catch (InterruptedException ie) {
	    }
	}
	buffer[index++] = num;
	notifyAll();
    }

    public synchronized int remove() {
	while(index == 0) {
	    try {
		wait();
	    } catch (InterruptedException ie) {
	    }
	}
	int ret =  buffer[--index];
	notifyAll();
	return ret;
    }
}
