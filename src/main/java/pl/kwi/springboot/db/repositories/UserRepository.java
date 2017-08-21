package pl.kwi.springboot.db.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.kwi.springboot.db.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	@Query("SELECT u FROM UserEntity u where u.email = ?1")
	public UserEntity findByEmail(String email);
	
	@Query("SELECT u FROM UserEntity u where u.enabled = 0")
	public List<UserEntity> findAllToApprove();

}
