package domain;

import java.util.List;

import db.PersonService;


public class Facade {


	private PersonService service;
	
	public Facade(){
		this.service = new PersonService();
	}
	
	public void addPerson(String nickName, String password,String status) {
		Person person = new Person(nickName, password,status);
		this.service.addPerson(person);
	}

	public void updateStatus(String status, String nickName){
		Person person = this.getPerson(nickName);
		person.setStatus(status);
	}



	public void addFriend(Person person, String nickName) {
		Person friend = this.service.getPerson(nickName);
		person.addFriend(friend);
		
		
	}

	public boolean hasNewMessage(boolean nieuw){
		return this.service.hasNewMessages(nieuw);
	}
	public Person getPerson(String nickName) {
		return this.service.getPerson(nickName);
	}

	public List<Person> getFriends(String nickName) {
		Person person = this.service.getPerson(nickName);
		return person.getFriends();
	}
	

	public Person logIn(String nickName,String password){
		Person person = this.service.getPerson(nickName);
		if(person.getPassword().equals(password)){
			return person;
		}
		else{
			return null;
		}
	}
}
