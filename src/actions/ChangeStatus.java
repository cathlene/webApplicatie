package actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Person;

public class ChangeStatus implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Person user= (Person) request.getSession().getAttribute("name");
		user.setStatus(request.getParameter("status"));
		return "iets"; // je mag hier eender wat schrijven
	}

}
