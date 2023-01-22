package service;

import java.util.ArrayList;
import java.util.List;

import model.Person;
import repository.PersonRepository;

public class PersonService {
	private final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<Person> allPerson(){
		return personRepository.allPerson();
	}
	
	public void addPerson(Person person) {
		personRepository.addPerson(person);
	}
	
	public void updatePerson(int id, Person person) {
		personRepository.updatePeson(id, person);
	}
	
	public void deletePerson(int id) {
		personRepository.deletePerson(id);
	}
	
	public ArrayList<String> getPerson(int id){
		return personRepository.getPerson(id);
	}
}
	
