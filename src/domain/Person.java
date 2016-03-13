package domain;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	private transient List<Person> friends;
	private String nickName;
	private String password;
	private String status;
	public Person(){
		
	}
	
	public Person(String nickName,String password, String status){
		this.setNickName(nickName);
		this.setPassword(password);
		this.setStatus(status);
		friends= new ArrayList<Person>();
		
	}

	public String getPassword(){
		return this.password;
	}
	
	public String getNickName(){
		return this.nickName;
	}
	public String getStatus(){
		return this.status;
	}
	public void setPassword(String password) {
		if (password.isEmpty()) {
			throw new IllegalArgumentException("No password given");
		}
		this.password = password;
	}
	public void setStatus(String status) {
		System.out.println("change");
		if (status.isEmpty()) {
			throw new IllegalArgumentException("No status given");
		}
		System.out.println(status);
		this.status = status;
		System.out.println(this.getNickName());
		System.out.println(this.status);
	}
	public void setNickName(String nickName) {
		if (nickName.isEmpty()) {
			throw new IllegalArgumentException("No nickName given");
		}
		this.nickName = nickName;
	}
	public void addFriend(Person person){
		this.friends.add(person);
		person.getFriends().add(this);
	}
	
	public List<Person> getFriends() {
		return friends;
	}
	
}
