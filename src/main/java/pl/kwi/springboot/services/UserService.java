package pl.kwi.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public void registerUser(String login, String password) {
		
		userRepository.save(new UserEntity(login, bCryptPasswordEncoder.encode(password), true));
		userRoleRepository.save(new UserRoleEntity(login, ROLE_ADMIN));
		
	}
	
	
}
