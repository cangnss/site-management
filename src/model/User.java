package model;

public class User {
	private int person_id;
	private int role_id;
	private String username;
	private String password;
	
	public User(int person_id, int role_id, String username, String password) {
		this.person_id = person_id;
		this.role_id = role_id;
		this.username = username;
		this.password = password;
	}
}
