package com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2.model.User;
import com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Iterable<User> find(String userName) {
		User sampleUser = new User(userName);
		return userRepository.findAll(Example.of(sampleUser));
	}

	public User validateUser(String userid, String password) {
		Iterable<User> results = find(userid);
		if (results.iterator().hasNext()) {
			User result = results.iterator().next();
			if (result.getPassword().equals(password)) {
				return result;
			}
		}
		return null;
	}
}
