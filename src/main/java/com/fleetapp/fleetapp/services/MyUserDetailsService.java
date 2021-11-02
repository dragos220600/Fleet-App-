package com.fleetapp.fleetapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fleetapp.fleetapp.models.User;
import com.fleetapp.fleetapp.models.UserPrincipal;
import com.fleetapp.fleetapp.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository  userRepository;

	/*
	 * UserDetailsService comes with Spring and
	 * delivers functionality like check credentials etc.
	 * @method loadUserByUsername checks if 
	 * username is in DB and if yes, loads an instance of User
	 * for the login session.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("User not found!");
		}
 
		return new UserPrincipal(user);//no return user; here, bc. springsecurity needs return Userprincipal??
	}

}
