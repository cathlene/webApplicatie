package actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import db.PersonService;
import domain.Message;
import domain.Person;

public class GetMessages implements RequestHandler {

	private PersonService personService;
	public GetMessages(PersonService personService){
		this.personService= personService;
		
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = createResult(request, response);
		return result;
		/*String result = createResult(request, response);
		response.setContentType("text/json");
		try {
			response.getWriter().write(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} in controller zou je dit schrijven*/
	}
	public String createResult(HttpServletRequest request, HttpServletResponse response){

		Gson gson= new Gson();
		List<Message>messages = null;
		try{
			Person user =  (Person) request.getSession().getAttribute("name"); 
			
			String nickName=request.getParameter("nickname"); 
			if (nickName == null) return "{\"messages\":\"\"}"; 
			Person friend= personService.getPerson(nickName);
			messages= user.getMessagesTo(friend);

		}catch(NullPointerException ex){

		}
		String json = gson.toJson(messages);
		return "{\"messages\":" + json + "}";
	}

}
