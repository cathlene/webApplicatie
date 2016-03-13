package actions;

import java.util.HashMap;
import java.util.Map;

import db.PersonService;

public class HandlerFactory {
	private Map<String,RequestHandler> handlers;

	public HandlerFactory(PersonService personService){
		handlers = new HashMap<String, RequestHandler>();
		handlers.put(null, new NullHandler()); 
		handlers.put("addNewFriend", new AddFriend(personService));
		handlers.put("overviewFriends", new FriendsOverview(personService));
		handlers.put("logIn", new LogIn(personService));	
		handlers.put("logOut", new LogOut());	
		handlers.put("changeStatus", new ChangeStatus());

	}
	
	public RequestHandler getHandler(String action){
		return this.handlers.get(action);
	}

}
