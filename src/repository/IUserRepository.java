package repository;

import java.util.ArrayList;

import model.User;

public interface IUserRepository {
	boolean isManager(String username, String password);
	boolean isManagerAss(String username, String password);
	boolean isController(String username, String password);
}
