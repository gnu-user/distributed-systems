import java.applet.Applet;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Shopper extends Applet{

	private ArrayList<Item> items;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String location = "http://localhost:8080/DepartmentStore/DepartmentServer";

	/*
	 * Initialize
	 */
	@Override
	public void init() {
		super.init();
		items = new ArrayList<Item>();
	}
	
	public int connectToServlet(){
		try {
			URL url = new URL(location);
			URLConnection conn = url.openConnection();
			conn.connect();
			InputStream is = conn.getInputStream();
			StringBuffer sb = new StringBuffer();
			InputStreamReader isr = new InputStreamReader(is);
			int numCharsRead;
			char[] charArray = new char[1024];
			while ((numCharsRead = isr.read(charArray)) > 0) {
				sb.append(charArray, 0, numCharsRead);
			}
			//System.out.println(sb.toString());
			Pattern p = Pattern.compile(".*?id=\"id\">([0-9]+)</h2>.*?<tbody id=\"sale_items\">(.*?)</tbody>.*");
			
			Matcher m = p.matcher(sb.toString());

			int id = 0;
			if(m.find())
			{
				id = Integer.valueOf(m.group(1));
				System.out.println("Items for sale!");
				
				String list = m.group(2);
				//System.out.println(list);
				items = Item.getItems(list);
				for(int i = 0; i < items.size(); i++){
					System.out.println("Name: "+items.get(i).getName() + " Quanity: "+items.get(i).getQuantity() + " Price: " + items.get(i).getPrice());
				}
				return id;
				//return Long.valueOf(m.group(0));
			}
			//return -1;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public void sendItem(int id, String item, int quanity)
	{
		try {
			URL url = new URL(location);
			URLConnection conn = url.openConnection();
			conn.setRequestProperty("Cookie", 
				DepartmentServer.ID+"="+id+";"+DepartmentServer.NAME+"="+item+";"+DepartmentServer.QUANITY+"="+quanity);
			conn.connect();
			InputStream is = conn.getInputStream();
			StringBuffer sb = new StringBuffer();
			InputStreamReader isr = new InputStreamReader(is);
			int numCharsRead;
			char[] charArray = new char[1024];
			while ((numCharsRead = isr.read(charArray)) > 0) {
				sb.append(charArray, 0, numCharsRead);
			}
			System.out.println("CLIENT RECEIVED: " + sb.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void start() {
		super.start();
		//RadioControlApplet s = new RadioControlApplet();
		//this.init();
		
		/*
		if(t == null)
		{
			t = new Thread(this);
		}
		t.start();*/
		
		int id = connectToServlet();
		Scanner in = new Scanner(System.in);
		//System.out.println("YOUR ID IS=" + id);
		if(id >= 0)
		{
			System.out.println("Enter the item you want!");
			String input = in.next();
			System.out.println("Enter the amount you want!");
			int amount = in.nextInt();
			
			sendItem(id, input, amount);
		}
		
		in.close();
	}
	
}
