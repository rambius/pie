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
	while(true) {
	    if (index < buffer.length) {
		buffer[index++] = num;
		return;
	    }
	}
    }

    public synchronized int remove() {
	while(true) {
	    if (index > 0) {
		return buffer[--index];
	    }
	}
    }
}
