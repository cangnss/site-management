package controller;

import java.util.ArrayList;
import java.util.List;

import model.Role;
import service.RoleService;

public class RoleController {
	private final RoleService roleService;

	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	public List<Role> allRole(){
		return roleService.allRole();
	}
	
	public void addRole(Role role) {
		roleService.addRole(role);
	}
	
	public void updateRole(int id, Role role) {
		roleService.updateRole(id, role);
	}
	
	public void deleteRole(int id) {
		roleService.deleteRole(id);
	}
	
	public ArrayList<String> getManagerInApartment(){
		return roleService.getManagerInApartment();
	}
	
}
