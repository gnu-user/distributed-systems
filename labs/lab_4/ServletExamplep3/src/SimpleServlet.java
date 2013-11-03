

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(name = "ServletExample2",  urlPatterns = { "/SimpleServlet" })
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static NXTRobotService roboController;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleServlet() {
        super();

    }

    public void init()
    {
        try {
			roboController = new NXTRobotService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);

		/*boolean excuted = false;
		
		switch (Integer.valueOf(request.getParameter("Cmd"))) {
		case NXTRobotService.STOP:
			roboController.stop(request.getParameter("Motor"));
			excuted =true;
			break;
		case NXTRobotService.FORWARD:
			roboController.forward(request.getParameter("Motor"));
			excuted = true;
			break;
		case NXTRobotService.BACKWARDS:
			roboController.backward(request.getParameter("MOTOR"));
			excuted = true;
			break;
		}
		
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
		*/
		
	}

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request,
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
}
