
public class Tester {
	
	public static void main(String[] args)
	{
		Counter result = new Counter();
		
		CountingThread a = new CountingThread("a", result);
		CountingThread b = new CountingThread("b", result);
		CountingThread c = new CountingThread("c", result);
		
		Thread aT = new Thread(a);
		Thread bT = new Thread(b);
		Thread cT = new Thread(c);
		
    	aT.start();
		bT.start();
		cT.start();		
	}

}
