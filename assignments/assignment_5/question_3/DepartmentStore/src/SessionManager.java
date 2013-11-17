import java.util.ArrayList;


public class SessionManager {

	private ArrayList<Item> itemsBought;
	
	/**
	 * The default constructor.
	 */
	public SessionManager()
	{
		this.itemsBought = new ArrayList<Item>();
	}
	
	/**
	 * A constructor to create a Session Manager from a list
	 * @param items
	 */
	public SessionManager(ArrayList<Item> items)
	{
		this.itemsBought = items;
	}

	/**
	 * Get the list of items.
	 * @return the itemsBought
	 */
	public ArrayList<Item> getItemsBought() {
		return itemsBought;
	}

	/**
	 * Set the list of items.
	 * @param itemsBought the itemsBought to set
	 */
	public void setItemsBought(ArrayList<Item> itemsBought) {
		this.itemsBought = itemsBought;
	}
}
