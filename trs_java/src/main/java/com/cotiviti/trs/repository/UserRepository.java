package com.cotiviti.trs.repository;

import com.cotiviti.trs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @project: trs
 * @author: Suresh Bhandari
 **/
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

	User findByUsernameAndPassword(String username, String password);
	
}
