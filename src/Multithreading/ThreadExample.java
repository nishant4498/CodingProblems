package Multithreading;
/**
 * When we extend thread we can directly call the start() method on the instance of the class.
 * On implementing the runnable interface we need to create an instance of class Thread and pass the class
 * instance as an argument to the Thread class constructor.
 */
public class ThreadExample extends Thread{
	public int count = 0;

	public void run() {
		System.out.println("Thread Example starting...");
		try {
			while (count < 5) {
				Thread.sleep(500);
				count++;
				System.out.println(count);
			}
		} catch (InterruptedException ex) {
			System.out.println("Thread interrupted");
		}
		System.out.println("Thread terminated!");
	}

	public static void main(String[] args) {
	    ThreadExample instance = new ThreadExample();
		instance.start();

		while (instance.count != 5) {
			try {
				Thread.sleep(250);
				System.out.println("Again");
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}
