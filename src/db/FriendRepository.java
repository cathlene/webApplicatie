package db;


import java.util.List;

import domain.Friend;

public interface FriendRepository {


	void addFriend(Friend friend);
	Friend getFriend(String nickName);
	void updateFriend(Friend friend);
	void deleteFriend(Friend friend);
	List<Friend> getAllFriends();
}
