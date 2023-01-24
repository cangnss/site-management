package service;
import repository.UserRepository;

public class UserService {
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public boolean isManager(String username, String password) {
		return userRepository.isManager(username, password);
	}
}
