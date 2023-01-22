package model;

import java.sql.Date;

public class Person {
	private int id;
	private String firstName;
	private String lastName;
	private String fullName;
	private String birthday;
	private int age;
	private String gender;
	private String email;
	private int apartman_id;
	
	public Person(String firstName, String lastName, String birthday, String gender,
			String email, int apartman_id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.gender = gender;
		this.email = email;
		this.apartman_id = apartman_id;
	}

	

	public Person(String firstName, String lastName, String email, int apartman_id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.apartman_id = apartman_id;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setGmail(String email) {
		this.email = email;
	}

	public int getApartman_id() {
		return apartman_id;
	}

	public void setApartman_id(int apartman_id) {
		this.apartman_id = apartman_id;
	}
	
}
