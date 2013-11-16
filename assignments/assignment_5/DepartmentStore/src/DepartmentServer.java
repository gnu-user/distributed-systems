

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DepartmentServer
 */
@WebServlet(name = "DepartmentServer", urlPatterns = { "/DepartmentServer"})
public class DepartmentServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private int sessionIds = 0; 
	public static final String NAME = "ID";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				
				if(i == 0)
				{
					if(!cookie.getName().equals(NAME) || Long.valueOf(cookie.getValue()) < sessionIds)
					{
						startNewSession(out);
					}
				}
				else
				{
					//TODO Look up items in the list
					String cookieName = cookie.getName();
					String cookieValue = cookie.getValue();
					out.println("Cookie Name: " + cookieName + 
						", Cookie Value: " + cookieValue);
					//TODO update html list once they take 
				}
				
			}
		} else {
			startNewSession(out);
		}
		
		out.flush();
		out.close();
	}
	
	private void startNewSession(PrintWriter out)
	{
		//TODO send available items or just a list
		sessionIds += 1;
		out.print("SessionId="+sessionIds);
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
		
		createResponse(request, response, Body.getHTMLPage(request.getParameter("Items")));
		
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
	
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet SimpleServlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet SimpleServlet at "
					+ request.getContextPath() + "</h1>");
			// add this line for lab
			out.println("<p>For Motor "+request.getParameter("Motor")+" direction is "+request.getParameter("Cmd")+"</p>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
	}
	
	private String getAvailableItems()
	{
		return "";
	}
	
}
