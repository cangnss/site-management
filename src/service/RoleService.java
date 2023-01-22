package service;

import java.util.ArrayList;
import java.util.List;

import model.Role;
import repository.RoleRepository;

public class RoleService {
	private final RoleRepository roleRepository;

	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	public List<Role> allRole(){
		return roleRepository.allRole();
	}
	
	public void addRole(Role role) {
		roleRepository.addRole(role);
	}
	
	public void updateRole(int id, Role role) {
		roleRepository.updateRole(id, role);
	}
	
	public void deleteRole(int id) {
		roleRepository.deleteRole(id);
	}
	
	public ArrayList<String> getManagerInApartment(){
		return roleRepository.getManagerInApartment();
	}
}
