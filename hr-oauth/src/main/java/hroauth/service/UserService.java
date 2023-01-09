package hroauth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hroauth.entities.User;
import hroauth.feignclient.UserFeignClient;

@Service
public class UserService {
	
	Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient client;
	
	public User findByEmail(String email) {
		User user = client.findByEmail(email).getBody();
		
		if(user == null) {
			logger.error("Email not Found: " + email);
			throw new IllegalArgumentException("Email not found");
		}
		logger.info("Email found: " + email);
		return user;
	}
}
