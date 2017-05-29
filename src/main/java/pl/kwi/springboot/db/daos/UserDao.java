package pl.kwi.springboot.db.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.kwi.springboot.db.entities.UserEntity;

@Transactional
@Repository
public class UserDao {
	
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	
	public long createUser(UserEntity user) {
		entityManager.persist(user);
		return user.getId();
	}
	
	public UserEntity readUserById(long id) {
		return entityManager.find(UserEntity.class, id);
	}
	

}
