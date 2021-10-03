package com.example.curso.services;

import java.util.List;
import java.util.Optional;

import com.example.curso.entities.User;
import com.example.curso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll(){
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> usr = repository.findById(id);
		return usr.get();
	}
}
