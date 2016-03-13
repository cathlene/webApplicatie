package ui;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actions.HandlerFactory;
import actions.RequestHandler;
import db.PersonService;

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
		try {String action = request.getParameter("action");
		RequestHandler handler = new HandlerFactory(personService).getHandler(action);
		 String destination = handler.handleRequest(request, response);
		 if(destination.contains(".jsp")){
				RequestDispatcher view = request.getRequestDispatcher(destination);
				view.forward(request, response);
			}
			else{
				response.getWriter().write(destination);
			}
			
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage(), ex);
		}
		
		
		
		
	}

}
