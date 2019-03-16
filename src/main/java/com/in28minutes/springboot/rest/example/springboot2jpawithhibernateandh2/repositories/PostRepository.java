package com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2.repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2.model.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
	Iterable<Post> findAll(Example<Post> probe);
}