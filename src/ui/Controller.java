package ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import actions.HandlerFactory;
import actions.RequestHandler;
import db.PersonService;
import domain.Message;
import domain.Person;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonService personService ;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		personService = new PersonService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.proccesRequest(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.proccesRequest(request, response);
	}
	protected void proccesRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String action = request.getParameter("action");
			if("hasNewMessage".equals(action)){
				hasNewMessages(request,response);	
			}
			else{RequestHandler handler = new HandlerFactory(personService).getHandler(action); // 
			String destination = handler.handleRequest(request, response);
			if(destination.contains(".jsp")){
				RequestDispatcher view = request.getRequestDispatcher(destination);
				view.forward(request, response);
			}
			else{
				response.getWriter().write(destination);
			}

			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage(), ex);
		}

	}


	private void hasNewMessages(HttpServletRequest request, HttpServletResponse response) {
		
		Person user =  (Person) request.getSession().getAttribute("name");
		String nickName=request.getParameter("nickname"); 
		Person friend= personService.getPerson(nickName);
		boolean newMessage= user.hasNewMessage();
		
		Gson gson= new Gson();

		String json = gson.toJson(newMessage);
		String user2= gson.toJson(user);
		
		 response.setContentType("text/json");
			try { 
				response.getWriter().write( "{\"newMessage\":" + json + ",\"user\":"+user2+"}");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
