	package actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.PersonService;
import domain.Person;

public class LogIn implements RequestHandler {

	private PersonService personService;
	public LogIn(PersonService person){
		this.personService=person;
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String nickName=request.getParameter("nickName");
		String password =request.getParameter("password");
		Person person= new Person();
		ArrayList<String> error= new ArrayList<>();
		
		try{
			person.setNickName(nickName);
			request.setAttribute("nickName", nickName);
		}catch(IllegalArgumentException ex){
			error.add(ex.getMessage());
		}
		try{
			personService.getPerson(nickName).isWrightPassword(password);

			person.setPassword(password);
			request.setAttribute("password", password);
		}catch(IllegalArgumentException ex){
			error.add(ex.getMessage());
		}
		if(error.isEmpty()){
			HttpSession session=request.getSession();
			Person person2=personService.getPerson(nickName);
			session.setAttribute("name", person2);
			return "index.jsp";
		}
		else{
			request.setAttribute("error", error);
			return "index.jsp";
		
		}
		
		
	}
	

}
