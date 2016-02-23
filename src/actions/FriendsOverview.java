package actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import db.FriendService;
import domain.Friend;


public class FriendsOverview implements RequestHandler {


	FriendService service;
	
	public FriendsOverview(FriendService service){
		this.service = service;
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response){
		Gson gson= new Gson();
		List<Friend>friends= service.getAllFriends();
		String json = gson.toJson(friends);
		return "{\"friends\":" + json + "}";

		
	
	}

}
