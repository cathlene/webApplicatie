package db;

import java.util.List;

import domain.Friend;

public class FriendService {
	
private FriendRepository friendRepository;
	
	public FriendService(){
		friendRepository= new FriendRepositoryStub();
	}

	private FriendRepository getFriendRepository() {
		return friendRepository;
	}

	public Friend getFriend(String nickName){
		return this.getFriendRepository().getFriend(nickName);
	}
	
	public void addFriend(Friend friend){
		this.getFriendRepository().addFriend(friend);
		
	}
	public List<Friend> getAllFriends(){
		return this.friendRepository.getAllFriends();
	}

}
