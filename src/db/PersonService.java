package db;

import java.util.List;

import domain.Message;
import domain.Person;

public class PersonService {
	private PersonRepository personRepository;

	public PersonService(){
		personRepository= new PersonRepositoryStub();
	}

	private PersonRepository getPersonRepository() {
		return personRepository;
	}

	public Person getPerson(String nickName){
		return this.getPersonRepository().getPerson(nickName);
	}
	public void addMessage(Message message){
		this.getPersonRepository().addMessage(message);
	}
	public List<Message> getMessages(){
		return this.getPersonRepository().getMessages();
	}
	public void addPerson(Person person){
		this.getPersonRepository().addPerson(person);
		
	}
	public List<Person> getAllFriends(){
		return this.personRepository.getAllPersons();
	}

	public boolean hasNewMessages(boolean nieuw) {
		return this.personRepository.hasNewMessages(nieuw);		
	}
	public int getAantalAway(){
		return this.personRepository.getAantalAway();
	}
	public int getAantalOnline(){
		return this.personRepository.getAantalOnline();
	}
	public int getAantalOffline(){
		return this.personRepository.getAantalOffline();
	}
}
