package hruser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hruser.entities.User;
import hruser.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User findById(Long id) {
		return repository.findById(id).get();
	}
	
	public User findByEmail(String email) {
		return repository.findByEmail(email);
	}
}
