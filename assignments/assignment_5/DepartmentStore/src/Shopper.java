import java.applet.Applet;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Shopper extends Applet{

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
			System.out.println(sb.toString());
			Pattern p = Pattern.compile(".*?=([0-9]+)");
			Matcher m = p.matcher(sb.toString());

			if(m.find())
			{
				return Integer.valueOf(m.group(1));
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
	
	public void sendItem(long id, String item, int quanity)
	{
		try {
			URL url = new URL(location);
			URLConnection conn = url.openConnection();
			conn.setRequestProperty("Cookie", 
				DepartmentServer.NAME+"="+id+";item="+item+";amount="+quanity);
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
		System.out.println("YOUR ID IS=" + id);
		if(id >= 0)
		{
			System.out.println("Enter the item you want!");
			String input = in.next();
			System.out.println("Enter the amount you want!");
			int amount = in.nextInt();
			
			sendItem(id, input, amount);
		}
	}
	
}
