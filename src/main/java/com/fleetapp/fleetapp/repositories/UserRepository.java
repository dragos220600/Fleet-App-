package com.fleetapp.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleetapp.fleetapp.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	/*
	 * Here, method name must be 'findBy' + 'fieldNameOfEntity'
	 * in order to be found by springsecurity.
	 */
	User findByUsername(String username);
	
}
