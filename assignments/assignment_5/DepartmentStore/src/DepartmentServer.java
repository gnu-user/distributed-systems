

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DepartmentServer
 */
@WebServlet(name = "DepartmentServer", urlPatterns = { "/DepartmentServer"})
public class DepartmentServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	public static final String ID = "ID";
	public static final String NAME = "NAME";
	public static final String QUANITY = "QUANITY";
	
	private ArrayList<Item> masterList;
	private ArrayList<User> users;
	private int sessionIds = 0;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentServer() {
        super();
        masterList = new ArrayList<Item>();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		masterList.add(new Item("Banana", 3, 3.22));
		masterList.add(new Item("Chopsticks", 5, 1.00));
		masterList.add(new Item("Boot straps", 2, 0.50));
		masterList.add(new Item("Pizza", 1, 5.00));
		masterList.add(new Item("SmartTable", 100, 10000.00));
		
		users = new ArrayList<User>();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		//processRequest(request, response);
		
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		int currentId = -1;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
								
				if(i == 0)
				{
					currentId = Integer.valueOf(cookies[i].getValue());
					if(!cookies[i].getName().equals(ID) || currentId < sessionIds)
					{
						startNewSession(request, response);
					}
				}
				else
				{
					if(currentId <= 0)
					{
						// Invalid session id
						break;
					}
					

					for(int j = 0; j < masterList.size(); j++)
					{
						int amount = Integer.valueOf(cookies[i+1].getValue());
						
						// Look up the items request and ensure a valid amount of the item is available for the user
						if(cookies[i].getName().equalsIgnoreCase(NAME) && this.masterList.get(j).getName()
								.equalsIgnoreCase(cookies[i].getValue()) && cookies[i+1].getName()
								.equalsIgnoreCase(QUANITY) && this.masterList.get(j).getQuantity() >=
								amount && amount > 0)
						{
							//Add to shopping cart
							int index = this.users.get(currentId-1).hasItem(this.masterList.get(j).getName());
							if(index >= 0)
							{
								this.users.get(currentId-1).getItems().get(index).increaseQuantity(amount);
							}
							else
							{
								Item temp = new Item(this.masterList.get(j).getName(), amount, this.masterList.get(j).getPrice());
								//temp.setQuantity(amount);
								this.users.get(currentId-1).getItems().add(temp);
							}
							
							// Update the master list
							this.masterList.get(j).decreaseQuantity(amount);					
							i++;
							break;
						}
					}
				}
				
			}
			createResponse(request, response, Body.getHTMLPage(sessionIds, Item.getTableEntries(masterList)));
		} else {
			startNewSession(request, response);
		}
		
		//out.flush();
		//out.close();
	}
	
	private void startNewSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//TODO send available items or just a list
		sessionIds += 1;
		users.add(new User(sessionIds));
		//out.println("SessionId="+sessionIds);
		//getAvailableItems(out);
		
		createResponse(request, response, Body.getHTMLPage(sessionIds, Item.getTableEntries(masterList)));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*String derp = "<html>";
		derp +="<head>";
		derp +="<title>Servlet SimpleServlet</title>";
		derp +="</head>";
		derp +="<body>";
		derp +="<h1>Yo MOMA</h1>";
		derp +="</body>";
		derp += "</html>";*/
		
		//createResponse(request, response, Body.getHTMLPage(request.getParameter("Items")));
		
		//processRequest(request, response);
	}

	private void createResponse(HttpServletRequest request,
			HttpServletResponse response, String html) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.println(html);
		} finally {
			out.close();
		}
	}
	
	
	/*private void getAvailableItems(PrintWriter out)
	{
		//ArrayList<String[]> items = null;
		
		if (masterList.size() > 0)
		{
			//items = new ArrayList<String[]>();
			for(int i = 0; i < masterList.size(); i++)
			{
				out.println(NAME + "=" + masterList.get(i).getName());
				out.println(QUANITY + "=" + masterList.get(i).getQuantity());
			}
		}
		//return items;
	}*/
	
}
