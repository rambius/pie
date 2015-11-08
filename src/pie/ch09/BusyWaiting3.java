package pie.ch09;

public class BusyWaiting3 {

    public static void main(String[] args) {

	class TaskThread extends Thread {
	    
	    public void run() {
		synchronized(this) {
		    try {
			sleep(30000);
		    } catch (InterruptedException ie) {
		    }
		    this.notify();
		}
	    }
	}

	Thread main = new Thread() {
		public void run() {
		    Thread task = new TaskThread();
		    synchronized(task) {
			task.start();
			try {
			    task.wait();
			} catch (InterruptedException ie) {
			}
			System.out.println("Task thread completed " + System.currentTimeMillis());
		    }
		}
	    };

	main.start();
    }
}
