package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullHandler  implements RequestHandler{

	public NullHandler(){
		
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		return "index.jsp";
	}
}
