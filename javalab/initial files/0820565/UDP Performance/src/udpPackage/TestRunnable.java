package udpPackage;

public class TestRunnable implements Runnable {

	public void run() {
		System.out.println("start thread");

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestRunnable tr=new TestRunnable();
		

	}

}
