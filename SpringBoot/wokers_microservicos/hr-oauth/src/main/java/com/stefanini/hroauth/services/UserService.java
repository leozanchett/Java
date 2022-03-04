package com.stefanini.hroauth.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.stefanini.hroauth.entities.User;
import com.stefanini.hroauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {

	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	public UserService() {
		// TODO Auto-generated constructor stub
	}
	
	public User findByEmail(String email) {
		Optional<User> optionalUser = userFeignClient.findByEmail(email);
		if (optionalUser.isPresent()) {
			logger.info("email found " + email);
			User user = userFeignClient.findByEmail(email).get();
			return user;
		}else {
			logger.error("email not found " + email);
			throw new IllegalArgumentException("Email not found");
		}
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUser = userFeignClient.findByEmail(username);
		if (optionalUser.isPresent()) {
			logger.info("email found " + username);
			User user = userFeignClient.findByEmail(username).get();
			return user;
		}else {
			logger.error("email not found " + username);
			throw new UsernameNotFoundException("Email not found");
		}
	}

}
