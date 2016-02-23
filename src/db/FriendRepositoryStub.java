package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Friend;

public class FriendRepositoryStub  implements FriendRepository{

	private Map<String, Friend> friends;

	public FriendRepositoryStub() {
		friends = new HashMap<String, Friend>();
		this.addFriend(new Friend("john","online"));

	}
	@Override
	public void addFriend(Friend friend) {
		if (friend == null) {
			throw new IllegalArgumentException("invalid friend");
		}
		if(friends.containsKey(friend.getNickName())){
			throw new IllegalArgumentException("Friend already added");
		}
		friends.put(friend.getNickName(), friend);
	}

	@Override
	public Friend getFriend(String nickName) {
		if (nickName == null) {
			throw new IllegalArgumentException("nickName not valid");
		}
		return friends.get(nickName);
	}

	@Override
	public void updateFriend(Friend friend) {

		if (friend== null) {
			throw new IllegalArgumentException("friend not valid");
		}
		friends.put(friend.getNickName(), friend);
	}

	@Override
	public void deleteFriend(Friend friend) {

		if (friend == null || ! friends.containsKey(friend.getNickName()) ) {
			throw new IllegalArgumentException("friend not valid");
		}
		friends.remove(friend);
	}

	@Override
	public List<Friend> getAllFriends() {
		return new ArrayList<Friend>(friends.values());

	}

}
