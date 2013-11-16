import java.util.ArrayList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Item {
	
	private String name;
	private int quantity;
	private double price;
	
	private static final Pattern HTML_PARSER = Pattern.compile("<tr.*?><td>(.+?)</td><td>(.+?)</td><td>(.+?)</td></tr>(.*)");
	
	public Item(String name, int quantity, double price)
	{
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	/**
	 * Get the name of the item
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the item.
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the quantity
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Set the quantity of the item
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Increase the quantity maintained
	 * @param the amount to increase the quantity by.
	 */
	public void increaseQuantity(int quantity) {
		this.quantity += quantity;
	}

	/**
	 * Decrease the quanity maintained
	 * @param the amount to increase the quanity by.
	 */
	public void decreaseQuantity(int quantity) {
		this.quantity -= quantity;
	}

	/**
	 * The price of the item.
	 * @return The price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Set the price of the item.
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Create the HTML table entry
	 * @return The html table entry for this item.
	 */
	public String getHTMLEntry()
	{
		String value = "<tr id=\"" + this.name + "\">";
		value += "<td>" + this.name + "</td>";
		value += "<td>" + this.quantity + "</td>";
		value += "<td>" + this.price + "</td>";
		value += "</tr>";
		return value;
	}
	
	public static String getTableEntries(ArrayList<Item> items)
	{
		String values = "";
		for(int i = 0; i < items.size(); i++)
		{
			values += items.get(i).getHTMLEntry();
		}
		return values;				
	}
	
	/**
	 * Parses the HTML list of strings 1 element at a time recursively until no element is let.
	 * @param list The HTML list of elements
	 * @return
	 */
	public static ArrayList<Item> getItems(String list)
	{
		ArrayList<Item> items = null;
		
		Matcher m = HTML_PARSER.matcher(list);
		
		if(m.find())
		{
			items = new ArrayList<Item>();
			
			Item item = new Item(m.group(1), Integer.valueOf(m.group(2)), Double.valueOf(m.group(3)));
			
			items = getItems(m.group(4));
			
			if(items!= null)
			{
				//Add the current item to the front of the list
				items.add(0, item);
			}
			else
			{
				items = new ArrayList<Item>();
				items.add(item);
			}
			
		}		
		
		return items;
	}

}
