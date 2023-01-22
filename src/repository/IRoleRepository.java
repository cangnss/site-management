package repository;

import java.util.ArrayList;
import java.util.List;

import model.Role;

public interface IRoleRepository {
	List<Role> allRole();
	void addRole(Role role);
	void updateRole(int id, Role role);
	void deleteRole(int id);
	ArrayList<String> getManagerInApartment();
}
