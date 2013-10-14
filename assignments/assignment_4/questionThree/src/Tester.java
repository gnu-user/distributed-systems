
public class Tester {
	
	public static void main(String[] args)
	{
		//CountingThread a = new CountingThread("a");
		//CountingThread b = new CountingThread("b");
		//CountingThread c = new CountingThread("c");
		
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
		
		/*Counter result = new Counter();*/
		/*while(a.getFinished() < 3)
		{
			
		}*/
		//System.out.println(result.getCount());
		
	}

}
