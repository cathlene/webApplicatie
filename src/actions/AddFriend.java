package actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
		String nickName=request.getParameter("nickName");
		Person friend= service.getPerson(nickName);
		Person user = (Person) request.getSession().getAttribute("name");
		user.addFriend(friend);
		return "index.jsp";
	}

}
