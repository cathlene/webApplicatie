package actions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import db.PersonService;
import domain.Person;
import domain.Message;

public class Messages implements RequestHandler {
	private PersonService personService;
	public Messages(PersonService personService){
		this.personService= personService;
		
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String message = request.getParameter("message");
		String nickname=request.getParameter("nickname");
		Person user=null;
		try{
			user = (Person) request.getSession().getAttribute("name");
		}catch(NullPointerException ex){

		}
		Person friend= personService.getPerson(nickname);
		message=user.getNickName()+": "+message;
		Message bericht= new Message(message, friend,user);
		user.addMessage(bericht);
		boolean l=user.hasNewMessage();
		friend.addMessage(bericht);
		friend.setNewMessage(true);
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
		return "alles";
	}

}
