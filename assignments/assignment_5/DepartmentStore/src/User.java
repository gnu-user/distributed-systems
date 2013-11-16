import java.util.ArrayList;

import javax.servlet.http.Cookie;


public class User extends Cookie{

	ArrayList<Item> items;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public User(String name, String value) {
		super(name, value);
		
		this.items = new ArrayList<Item>();
	}
	
	public User(String name, String value, ArrayList<Item> list) {
		super(name, value);
		this.items = list;
	}

	public ArrayList<Item> getItems()
	{
		return this.items;
	}

	public void setItems(ArrayList<Item> item)
	{
		this.items = item;
	}
}
