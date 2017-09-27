package pl.kwi.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.kwi.springboot.db.entities.UserEntity;
import pl.kwi.springboot.db.repositories.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	public long createUserWithName(String name) {
		UserEntity user = new UserEntity();
		user.setName(name);
		user = userRepository.save(user);
		return user.getId();
	}
	
	public String getNameUserById(long id) {
		UserEntity user = userRepository.findOne(id);
		return user.getName();
	}
	

}
