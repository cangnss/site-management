package controller;

import java.util.ArrayList;

import model.User;
import service.UserService;

public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	public boolean isManager(String username, String password) {
		return userService.isManager(username, password);
	}
}
