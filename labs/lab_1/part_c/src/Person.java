import java.io.Serializable;


public class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	
	public Person (String name)
	{
		this.name = name;
	}

}
