package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Message;
import domain.Person;

public class PersonRepositoryStub implements PersonRepository {
	private Map<String, Person> persons;
	private List<Message>messages;

	 public PersonRepositoryStub() {
		persons = new HashMap<String, Person>();
		messages= new ArrayList<Message>();
		Person person1 =new Person("john","john","online");
		Person person2 =new Person("johnny", "johnny", "offline");
		Person person3 =new Person("jes", "jes", "offline");
			
		this.addPerson(person1);
		this.addPerson(person2);
		this.addPerson(person3);
		person1.setNewMessage(false);
		person2.setNewMessage(false);
		person3.setNewMessage(false);
		

	}
	@Override
	public void addPerson(Person person) {

		if (person == null) {
			throw new IllegalArgumentException("invalid person");
		}
		if(persons.containsKey(person.getNickName())){
			throw new IllegalArgumentException("Person already added");
		}
		persons.put(person.getNickName(), person);
	}
	
	public void addMessage(Message message){
		messages.add(message);
	}
	
	public List<Message> getMessages() {
		return messages;
	}
	
	@Override
	public Person getPerson(String nickName) {
		if (nickName == null || !persons.containsKey(nickName)) {
			throw new IllegalArgumentException("nickName not valid");
		}
		return persons.get(nickName);
	}

	@Override
	public void updatePerson(Person person) {
		if (person== null || !persons.containsKey(person.getNickName())) {
			throw new IllegalArgumentException("person not valid");
		}
		persons.put(person.getNickName(), person);
	}

	@Override
	public void deletePerson(Person person) {

		if (person == null || ! persons.containsKey(person.getNickName()) ) {
			throw new IllegalArgumentException("friend not valid");
		}
		persons.remove(person);
	}

	@Override
	public List<Person> getAllPersons() {
		return new ArrayList<Person>(persons.values());

	}
	@Override
	public boolean hasNewMessages(boolean nieuw) {
		return true;
	}
	@Override
	public int getAantalOffline(){
		
		int counter=0;
		for(Person person : this.getAllPersons()){
			if(person.getStatus().equals("offline")){
				counter++;
			}
		}
		return counter;
	}
	
	@Override
	public int getAantalOnline(){
		
		int counter=0;
		for(Person person : this.getAllPersons()){
			if(person.getStatus().equals("online")){
				counter++;
			}
		}
		return counter;
	}
	
	@Override
	public int getAantalAway(){
	
	int counter=0;
	for(Person person : this.getAllPersons()){
		if(person.getStatus().equals("away")){
			counter++;
		}
	}
	return counter;
}

}
