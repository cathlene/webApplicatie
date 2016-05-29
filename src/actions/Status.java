package actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import db.PersonService;
import domain.Person;

public class Status implements RequestHandler {
	
	private PersonService personService;
	public Status(PersonService personService){
		this.personService= personService;
		
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return (toJSON(personService));
		
	}


	private String toJSON(PersonService personService) {
		Gson gson= new Gson();

		String online= gson.toJson(personService.getAantalOnline());
		String offline= gson.toJson(personService.getAantalOffline());
		String away= gson.toJson(personService.getAantalAway());

		return "{\"online\":" + online + ",\"offline\":"+offline+ ",\"away\":"+away+"}";
		
	}

}

