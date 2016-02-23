package actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.FriendService;
import domain.Friend;


public class AddFriend implements RequestHandler {


	FriendService service;
	
	public AddFriend(FriendService service){
		this.service = service;
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("addFriend");
		String nickName=request.getParameter("nickName");
		String status = request.getParameter("status");
		Friend friend = new Friend(nickName,status);
		service.addFriend(friend);
		return "index.jsp";
	}

}
