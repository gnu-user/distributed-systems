import java.io.Serializable;


public class Couple implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Person one;
	private Person two;
	
	public Couple(Person a, Person b) {
		one = a;
		two = b;
	}
	
	public Person getPersonOne()
	{
		return this.one;
	}
	
	public Person getPersonTwo()
	{
		return this.two;
	}
}
