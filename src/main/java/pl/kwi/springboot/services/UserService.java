package pl.kwi.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.kwi.springboot.db.entities.UserEntity;
import pl.kwi.springboot.db.entities.UserRoleEntity;
import pl.kwi.springboot.db.repositories.UserRepository;
import pl.kwi.springboot.db.repositories.UserRoleRepository;

@Service
public class UserService {
	
	
	private final static String ROLE_ADMIN = "ROLE_ADMIN";
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	
	public void registerUser(String login, String password) {
		
		userRepository.save(new UserEntity(login, password, true));
		userRoleRepository.save(new UserRoleEntity(login, ROLE_ADMIN));
		
	}
	
	
}
