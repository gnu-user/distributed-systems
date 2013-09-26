public class NXTCommExample {

	public static void main(String[] args) {
		/* I am putting this in a Thread so that I can sleep the thread */

		Thread thread = new BasicNXTThread();
		thread.start();
	}
}