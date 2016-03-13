package actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import db.PersonService;
import domain.Person;


public class FriendsOverview implements RequestHandler {


	PersonService service;
	
	public FriendsOverview(PersonService service){
		this.service = service;
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response){
		Gson gson= new Gson();
		List<Person>friends = null;
		try{
		 Person user =  (Person) request.getSession().getAttribute("name");
			friends= user.getFriends();

		}catch(NullPointerException ex){
			
		}
		String json = gson.toJson(friends);
		return "{\"friends\":" + json + "}";

		
	
	}

}
