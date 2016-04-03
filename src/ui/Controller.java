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
			String action = request.getParameter("action"); // Parameter bestaat ni wss :p jawel jawel ik gebruikte da daarvoor al
			if (action == null) return; // gvd :p 
			if("message".equals(action)){ 
				messageStuff(request,response); 
				return; // werkt da zo? ik denk wel da da gaat
			}
			else if("getMessages".equals(action)){
				getMessageStuff(request,response);
				return;
			}
			RequestHandler handler = new HandlerFactory(personService).getHandler(action); // 
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

	private void getMessageStuff(HttpServletRequest request, HttpServletResponse response) {

		String result = createResult(request, response);
		response.setContentType("text/json");
		try {
			response.getWriter().write(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public String createResult(HttpServletRequest request, HttpServletResponse response){

		Gson gson= new Gson();
		List<Message>messages = null;
		try{
			Person user =  (Person) request.getSession().getAttribute("name");
			messages= user.getMessages();

		}catch(NullPointerException ex){

		}
		String json = gson.toJson(messages);
		return "{\"messages\":" + json + "}";
	}

	public void messageStuff(HttpServletRequest request, HttpServletResponse response){

		String message = request.getParameter("message");
		Message bericht= new Message(message);
		String nickname=request.getParameter("nickname");
		Person user=null;
		try{
			user = (Person) request.getSession().getAttribute("name");
		}catch(NullPointerException ex){

		}
		Person friend= personService.getPerson(nickname);
		user.addMessage(bericht);
		friend.addMessage(bericht);

		response.setContentType("text/plain");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("" + message + "");
		out.flush();
		out.close();

	}

}
