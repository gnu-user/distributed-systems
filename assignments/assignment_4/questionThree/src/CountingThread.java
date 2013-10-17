
public class CountingThread implements Runnable{

	private Counter count;
	private String name;

	public CountingThread(String name, Counter count)
	{
		this.name = name;
		this.count = count;
	}
	
	@Override
	public void run() {
		//Counter count = new Counter();
		
		for(int i = 0; i < 10; i++)
		{
			count.increaseCount();
			
		}
		System.out.println(name + " " + count.getCount());
	}
}
