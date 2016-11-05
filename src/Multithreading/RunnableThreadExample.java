package Multithreading;
/**
 * Benefits of implementing runnable:
 * 
 * 1) Sice Java does not support multiple inheritance, extending Thread class means that we cannot extend any other class.
 *    If we implement Runnable we still will be able to extend a class.
 *    
 * 2) The second advantage is, when we extend Thread we are inheriting the full overhead of the Thread class when we 
 *    only need the run() method. 
 */
public class RunnableThreadExample implements Runnable{
	public int count  = 0;
	
	public void run(){
		System.out.println("Runnable thread starting...");
		try{
			while(count < 5){
				Thread.sleep(500);
				count++;
				System.out.println(count);
			}
		}catch(InterruptedException ex){
			System.out.println("Runnable thread interrupted");
		}
		System.out.println("Runnable thread terminated!");
	}
	
	public static void main(String[] args) {
		RunnableThreadExample instance = new RunnableThreadExample();
		Thread myThread = new Thread(instance);
		myThread.start();
		
		while(instance.count != 5){
			try{
				Thread.sleep(250);
				System.out.println("Again");
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}
	}
}


