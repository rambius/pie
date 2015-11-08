package pie.ch09;

public class BusyWaiting {

    public static void main(String[] args) {
	Thread task = new Thread() {
		public void run() {
		    try {
			sleep(30000);
		    } catch (InterruptedException ie) {
		    }
		}
	    };
	Thread main = new Thread() {
		public void run() {
		    task.start();
		    while (task.isAlive()) {
			System.out.println("Waiting for task thread to complete " + System.currentTimeMillis());
		    }
		    System.out.println("Task thread completed " + System.currentTimeMillis());
		}
	    };

	main.start();
    }
}
