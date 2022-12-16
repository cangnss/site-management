package model;

import java.util.Date;

public class Resident {
	private int id;
	private String firstName;
	private String lastName;
	private Date birthday;
	private String fullName;
	private char gender;
	private int apartmendId;
	
	public Resident(int id, String firstName, String lastName, Date birthday, String fullName, char gender,
			int apartmendId) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.fullName = fullName;
		this.gender = gender;
		this.apartmendId = apartmendId;
	}
	
	
	
	
}
