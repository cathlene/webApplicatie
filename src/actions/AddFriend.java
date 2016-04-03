package actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import db.PersonService;
import domain.Person;


public class AddFriend implements RequestHandler {


	PersonService service;
	
	public AddFriend(PersonService service){
		this.service = service;
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!isLoggedIn(request)) {
			System.out.println("niet ingelogd");

			JOptionPane.showMessageDialog(null, "U moet zich eerst inloggen alvores u vrienden kan toevoegen");
			return "index.jsp";
		}
		String nickName=request.getParameter("nickName");
		Person friend= service.getPerson(nickName);
		Person user = (Person) request.getSession().getAttribute("name");
		user.addFriend(friend);
		return "index.jsp";
	}
	private boolean isLoggedIn(HttpServletRequest request) {
		Person person = (Person) request.getSession().getAttribute("name");
		if (person == null) { 
			return false;
		}
		return true;
	}

}
