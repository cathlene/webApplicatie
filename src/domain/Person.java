package domain;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	private transient List<Person> friends;
	private transient List<Message>messages;
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
		messages= new ArrayList<Message>();
		
	}

	public String getPassword(){
		return this.password;
	}
	
	public boolean isWrightPassword(String password){
		
 		if(!this.password.equals(password)){
			throw new IllegalArgumentException("invalid password");
		}
		return true;
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
		if (status.isEmpty()) {
			throw new IllegalArgumentException("No status given");
		}
		this.status = status;
		
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
	
	public void addMessage(Message message){
		this.messages.add(message);
	}
	
	public List<Person> getFriends() {
		return friends;
	}
	
	public List<Message> getMessages() {
		return messages;
	}

	public List<Message> getMessagesTo(Person user) {
		List<Message> allMessages = getMessages();
		ArrayList<Message> relevantMessages = new ArrayList<>();
		
		for(Message m : allMessages) { 
			if (m.getTarget().equals(user) || m.getSender().equals(user))
				relevantMessages.add(m);
		}
		
		return relevantMessages;
	}
	
	public String toStringMessages() {
		String text="";
		for(Message m : messages){
			text+=m.getMessage()+" \t";
			
		}
		return text;
	}
	public String toStringMessages(List<Message> messages) {
		String text="";
		for(Message m : messages){
			text+=m.getMessage()+" \t";
			
		}
		return text;
	}
}
