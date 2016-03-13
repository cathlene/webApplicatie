package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Friend;
import domain.Person;

public class PersonRepositoryStub implements PersonRepository {
	private Map<String, Person> persons;

	 public PersonRepositoryStub() {
		persons = new HashMap<String, Person>();
		this.addPerson(new Person("john","john","online"));
		this.addPerson(new Person("johnny", "johnny", "offline"));
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

}
