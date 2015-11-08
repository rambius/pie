package pie.ch09;

public class BusyWaiting2 {

    public static void main(String[] args) {

	class TaskThread extends Thread {

	    private Object lock;
	    
	    public TaskThread(Object lock) {
		this.lock = lock;
	    }
	    
	    public void run() {
		synchronized(lock) {
		    try {
			sleep(30000);
		    } catch (InterruptedException ie) {
		    }
		    lock.notify();
		}
	    }
	}

	Thread main = new Thread() {
		public void run() {
		    Object lock = new Object();
		    synchronized(lock) {
			Thread task = new TaskThread(lock);
			task.start();
			try {
			    lock.wait();
			} catch (InterruptedException ie) {
			}
			System.out.println("Task thread completed " + System.currentTimeMillis());
		    }
		}
	    };

	main.start();
    }
}
