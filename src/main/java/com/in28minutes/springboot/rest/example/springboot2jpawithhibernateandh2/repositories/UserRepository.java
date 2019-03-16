package com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Example;

import com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	Iterable<User> findAll(Example<User> probe);
}
