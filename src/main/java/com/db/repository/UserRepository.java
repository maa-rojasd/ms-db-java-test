package com.db.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.db.model.UserModel;
@Component
@Repository
public interface UserRepository extends CrudRepository<UserModel, Long>{
	
	
	public boolean existsByEmail(String email);
	public boolean findByEmailAndPassword(String email, String password);
}
