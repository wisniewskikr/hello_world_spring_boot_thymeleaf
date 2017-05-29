package pl.kwi.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.kwi.springboot.db.daos.UserDao;
import pl.kwi.springboot.db.entities.UserEntity;

@Service
public class UserService {
	
	
	@Autowired
	private UserDao userDao;
	
	
	public long createUserWithName(String name) {
		UserEntity user = new UserEntity();
		user.setName(name);
		return userDao.createUser(user);
	}
	
	public String getNameUserById(long id) {
		UserEntity user = userDao.readUserById(id);
		return user.getName();
	}
	

}
