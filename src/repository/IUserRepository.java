package repository;

import java.util.ArrayList;

import model.User;

public interface IUserRepository {
	boolean isManager(String username, String password);
}
