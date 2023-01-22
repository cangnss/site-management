package repository;

import java.util.ArrayList;
import java.util.List;
import model.Person;


public interface IPersonRepository {
	List<Person> allPerson();
	void addPerson(Person person);
	void updatePeson(int id, Person person);
	void deletePerson(int id);
	ArrayList<String> getPerson(int id);
}
