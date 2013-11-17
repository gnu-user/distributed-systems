import java.util.ArrayList;

public class User {

	private ArrayList<Item> items;
	private int id;
	
	public User(int id) {
		
		this.items = new ArrayList<Item>();
		this.id = id;
	}
	
	public User(int id, ArrayList<Item> list) {
		this.items = list;
		this.id = id;
	}

	public ArrayList<Item> getItems()
	{
		return this.items;
	}

	public void setItems(ArrayList<Item> item)
	{
		this.items = item;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	public int hasItem(String name)
	{
		for(int i = 0; i < this.items.size(); i++)
		{
			if(this.items.get(i).getName().equalsIgnoreCase(name))
			{
				return i;
			}
		}
		return -1;
	}
}
