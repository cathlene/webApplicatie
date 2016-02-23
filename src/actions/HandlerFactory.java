package actions;

import java.util.HashMap;
import java.util.Map;

import db.FriendService;

public class HandlerFactory {
	private Map<String,RequestHandler> handlers;

	public HandlerFactory(FriendService friendService){
		handlers = new HashMap<String, RequestHandler>();
		handlers.put(null, new NullHandler());
		handlers.put("addNewFriend", new AddFriend(friendService));
		handlers.put("overviewFriends", new FriendsOverview(friendService));
		//handlers.put("friendsPage", new FriendPageHandler());
	}
	
	public RequestHandler getHandler(String action){
		return this.handlers.get(action);
	}

}
