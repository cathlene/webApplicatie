package db;

import java.util.List;

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
	
	public void addPerson(Person person){
		this.getPersonRepository().addPerson(person);
		
	}
	public List<Person> getAllFriends(){
		return this.personRepository.getAllPersons();
	}
}
