package controller;

import java.util.ArrayList;
import java.util.List;

import model.Person;
import service.ApartmentService;
import service.PersonService;

public class PersonController {
	private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	public List<Person> allPerson(){
		return personService.allPerson();
	}
	
	public void addPerson(Person person) {
		personService.addPerson(person);
	}
	
	public void updatePerson(int id, Person person) {
		personService.updatePerson(id, person);
	}
	
	public void deletePerson(int id) {
		personService.deletePerson(id);
	}
	
	public ArrayList<String> getPerson(int id){
		return personService.getPerson(id);
	}
	
}
