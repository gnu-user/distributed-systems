import java.util.ArrayList;


public class Item {
	
	private String name;
	private int quantity;
	private double price;
	
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

}
