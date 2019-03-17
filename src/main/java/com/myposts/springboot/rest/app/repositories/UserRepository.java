package com.myposts.springboot.rest.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Example;

import com.myposts.springboot.rest.app.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	Iterable<User> findAll(Example<User> probe);
}
