package db;

import java.util.List;

import domain.Message;
import domain.Person;

public interface PersonRepository {
	
	void addPerson(Person person);
	Person getPerson(String nickName);
	void updatePerson(Person person);
	void deletePerson(Person person);
	List<Person> getAllPersons();
	void addMessage(Message message);
	List<Message> getMessages();
}
